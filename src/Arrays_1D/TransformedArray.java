package arrays_1d;

import java.util.Arrays;

public class TransformedArray {
    public static void main(String[] args) {
        int[] nums = {3,-2,1,1};
        System.out.println(Arrays.toString(constructTransformedArray(nums)));
    }

    static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) res[i] = 0;
            else {
                int index = (i + nums[i]) % n;
                if (index < 0) index +=n;
                res[i] = nums[index];
            }
        }
        return res;
    }
}
