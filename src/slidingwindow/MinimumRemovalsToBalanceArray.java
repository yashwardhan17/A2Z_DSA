package slidingwindow;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {
    public static void main(String[] args) {
        int[] arr = {1,6,2,9};
        int k = 3;
        System.out.println(minRemoval(arr, k));
    }

    static int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return 0;
        Arrays.sort(nums);
        int ans = n;
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && (long) nums[r] <= (long) k * nums[i]) {
                r++;
            }
            int windowSize = r - i;
            ans = Math.min(ans, n - windowSize);
        }
        return ans;
    }
}
