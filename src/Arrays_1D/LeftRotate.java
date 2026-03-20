package arrays_1d;

import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        int n = arr.length;
        System.out.println(Arrays.toString(leftRotate(arr, n)));
    }
    // O(n)
    // left rotate by 1 place
    static int[] leftRotate(int[] arr, int n){
        int i = 0;
        for (int j = 1; j < n; j++) {
            swap(arr, i, j);
            i++;
        }
        return arr;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
