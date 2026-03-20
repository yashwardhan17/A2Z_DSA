package arrays_1d;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static void main(String[] args) {
        int[] arr = {3, 3, 6, 8};
        int target = 10;
        System.out.println(numSubseq(arr, target));
    }

    static int numSubseq(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);

        int mod = 1_000_000_007;

        // Precompute powers of 2
        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int left = 0;
        int right = n - 1;
        long count = 0;

        while (left <= right) {
            if (arr[left] + arr[right] <= target) {
                count = (count + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return (int) count;
    }
}
