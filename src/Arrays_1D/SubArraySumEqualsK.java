package Arrays_1D;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        int k = 3;
        System.out.println(SubArrayEqualsK(arr, n, k));
    }

    //T.C = O(n^2)
    static int SumEqualsK(int[] arr, int n, int k){
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //Using HashMap //T.C = O(n) and S.C = O(n)
    static int SubArrayEqualsK(int arr[], int n, int k){
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        int sum = 0;
        int cnt = 0;
        for(int i : arr){
            sum += i;
            if(prefixSum.containsKey(sum-k)){
                cnt += prefixSum.get(sum-k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
