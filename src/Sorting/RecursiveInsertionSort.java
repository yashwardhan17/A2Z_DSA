package Sorting;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] arr = {12,11,13,5,6};
        int n = arr.length;
        RecursiveInsertionSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void RecursiveInsertionSort(int[] arr, int n){
        if (n==1) return;
        RecursiveInsertionSort(arr, n-1);

        int last = n-1;
        int j = n-2;
        while(j >= 0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
}

