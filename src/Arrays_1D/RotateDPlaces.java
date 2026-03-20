package arrays_1d;

import java.util.Arrays;

public class RotateDPlaces {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        int D = 3;
        rotateLeftByD(arr, n, D);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateRightByD(int[] arr, int n, int D) {
        if (n == 0 || D == 0) return;

        D = D % n;

        Reverse(arr, 0, n-1);

        Reverse(arr, 0, D-1);

        Reverse(arr, D, n-1);
    }

    static void rotateLeftByD(int[] arr, int n, int D) {
        if (n == 0 || D == 0) return;

        D = D % n;

        Reverse(arr, 0, D-1);
        Reverse(arr, D, n-1);
        Reverse(arr, 0, n-1);
    }

    public static void Reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
