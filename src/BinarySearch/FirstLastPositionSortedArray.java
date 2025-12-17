package BinarySearch;

import java.util.Arrays;

public class FirstLastPositionSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,7,8,8,8,10};
        int n = arr.length;
        int target = 8;
        System.out.println(Arrays.toString(FirstLastPos(arr, n, target)));
    }

    //T.C = O(logN)
    static int[] FirstLastPos(int[] arr, int n, int target) {
        int start = 0;
        int end = n-1;
        int first = -1;
        int last = -1;

        while (start <= end) {

            int mid = start + ((end - start) / 2);

            if (target == arr[mid]) {
                first = mid;
                end = mid - 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //reset start and end
        start = 0;
        end = n-1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (target == arr[mid]) {
                last = mid;
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[] { first, last };
    }
}
