package Arrays_1D;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        System.out.println(Arrays.toString(nextPermutation(arr, n)));
    }

    //T.C = O(n) and S.C = O(1)
    static int[] nextPermutation(int[] arr, int n){
        int index = -1;
        for (int i = n-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }
        if (index == -1) {
            Reverse(arr, 0, n - 1);
            return arr;
        }

        for (int i = n-1; i > index; i--) {
            if(arr[i] > arr[index]){
                swap(arr, i, index);
                break;
            }
        }
        Reverse(arr, index + 1, n - 1);

        return arr;
    }

    static void Reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
