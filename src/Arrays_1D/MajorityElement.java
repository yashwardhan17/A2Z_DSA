package arrays_1d;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int n = arr.length;
        System.out.println(majorityElement(arr, n));
    }

    //T.C - O(n) //S.C - O(n)
    static int majorityEle(int[] arr, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > n/2){
                return key;
            }
        }
        return -1;
    }

    // Boyer - Moore Voting Algo
    // O(n) & O(1)
    static int majorityElement(int[] arr, int n) {
        int cnt = 0;
        int candidate = 0;
        for (int i : arr) {
            if (cnt == 0) {
                candidate = i;
                cnt = 1;
            }

            else if (i == candidate) {
                cnt++;
            }

            else {
                cnt--;
            }
        }
        return candidate;

        // if majority element is not guaranteed, we will add a verification pass
        /*
        int freq = 0;
        for (int num : nums) {
            if (num == candidate) freq++;
        }

        if (freq > n / 2) return candidate;

        return -1;
        */
    }
}
