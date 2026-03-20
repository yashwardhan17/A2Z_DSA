package arrays_1d;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }

    // T.C = O(n log n) and S.C = O(n)
    private static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int count = 0;

        // count in left half
        count += mergeSort(nums, left, mid);

        // count in right half
        count += mergeSort(nums, mid + 1, right);

        // count cross reverse pairs
        count += countPairs(nums, left, mid, right);

        // merge the two sorted halves
        merge(nums, left, mid, right);

        return count;
    }

    private static int countPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            // move j while condition holds
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            // all elements before j are valid
            count += (j - (mid + 1));
        }

        return count;
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        // copy back
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}
