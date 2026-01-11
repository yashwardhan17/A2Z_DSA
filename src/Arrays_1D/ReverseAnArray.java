package Arrays_1D;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;

        reverse(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

        reverseUsing1Pointer(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr, int l, int r) {
        if (l >= r) return;
        swap(arr, l, r);
        reverse(arr, l+1, r-1);
    }

    static void reverseUsing1Pointer(int[] arr, int i) {
        int n = arr.length;
        if (i >= n / 2 ) return;

        swap(arr, i, n - i - 1);
        reverseUsing1Pointer(arr, i + 1);
    }

    static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
