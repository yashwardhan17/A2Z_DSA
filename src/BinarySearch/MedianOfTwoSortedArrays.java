package BinarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        System.out.println(medianOfSortedArrays(arr1, arr2));
    }

    // Time Complexity : O(min(log (m+n))) and Space Complexity : O(1)
    static double medianOfSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2) return medianOfSortedArrays(arr2, arr1);
        int start = 0;
        int end = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;

        while (start <= end) {
            int mid1 = start + ((end - start) / 2);
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n1) {
                r1 = arr1[mid1];
            }

            if (mid2 < n2) {
                r2 = arr2[mid2];
            }

            if (mid1 - 1 >= 0) {
                l1 = arr1[mid1 - 1];
            }

            if (mid2 - 1 >= 0) {
                l2 = arr2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }
        return 0;
    }
}
