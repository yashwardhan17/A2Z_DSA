package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7,4,5,1,2};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void BubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i]>arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr [j] = temp;
    }
}
