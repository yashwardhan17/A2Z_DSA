package Sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {7,4,5,1,2};
        int n = arr.length;
        RecursiveBubbleSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void RecursiveBubbleSort(int[] arr, int n){
        if(n == 1) return;
        for (int i = 0; i < n - 1; i++) {
            if(arr[i] > arr[i+1]){
                swap(arr, i, i+1);
            }
        }
        RecursiveBubbleSort(arr, n-1);
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr [j] = temp;
    }
}

