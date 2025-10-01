package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {7,4,5,1,2};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void SelectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minINDEX = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minINDEX]) {
                    minINDEX = j;
                }
            }
            swap(arr, i, minINDEX);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr [j] = temp;
    }
}
