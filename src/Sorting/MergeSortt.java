package Sorting;

import java.util.Arrays;

public class MergeSortt {
    public static void main(String[] args) {
        int[] arr = {5,4,10,3,1,2};
        MergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void MergeSort(int[] arr){
        //Base case : already sorted
        if (arr.length <= 1) return;

        int mid = arr.length/2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        //fill left array
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        //fill right array
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        //recursively sort both the halves
        MergeSort(left);
        MergeSort(right);

        merge(arr, left, right);

    }

    static void merge(int[] arr, int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        //copy remaining elements into the arr
        while(i < left.length){
            arr[k++] = left[i++];
        }

        while(j < right.length){
            arr[k++] = right[j++];
        }
    }
}
