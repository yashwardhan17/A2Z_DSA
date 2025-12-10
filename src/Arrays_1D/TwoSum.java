package Arrays_1D;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int n = arr.length;
        int target = 14;
        System.out.println(Arrays.toString(TwoS(arr, target, n)));
    }

    //O(n)
    static int[] TwoS(int[] arr, int target, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
