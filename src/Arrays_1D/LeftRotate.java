package Arrays_1D;

import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        int n = arr.length;
        System.out.println(Arrays.toString(rotate(arr, n)));
    }
    //O(n)
    static int[] rotate(int[] arr, int n){
        int i = 0;
        for (int j = 1; j < n; j++) {
            swap(arr, i, j);
        }
        return arr;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
