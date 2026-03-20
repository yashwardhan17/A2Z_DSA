package arrays_1d;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prod = 1;

        // A single left-to-right pass can miss the maximum product when the optimal subarray starts after a negative number.
        for (int i = 0; i < n; i++) {
            prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
            if (prod == 0) {
                prod = 1;
            }
        }

        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
            if (prod == 0) {
                prod = 1;
            }
        }
        return maxProd;
    }
}
