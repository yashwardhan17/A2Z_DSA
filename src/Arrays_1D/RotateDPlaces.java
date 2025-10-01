package Arrays_1D;

import java.util.Arrays;

public class RotateDPlaces {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        int D = 3;
        rotate(arr, n, D);
        System.out.println(Arrays.toString(arr));
    }
    //O(n)
    static void rotate(int[] arr, int n, int D){
        if (n == 1)
            return;
        if (D == 0)
            return;
        D %= n;

        Reverse(arr, n-D, n-1 );

        Reverse(arr, 0, n-D-1);

        Reverse(arr, 0, n-1);
    }

/*    public static void Reverse(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[(n - 1) - i];
            arr[(n - 1) - i] = temp;
        }
    }

*/

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
