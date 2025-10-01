package Arrays_1D;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 10, 2};
        System.out.println(findLargest(arr));
    }

    //O(n)
    //linearly searching max through the array
    static int findLargest(int[] arr){
        int n = arr.length;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
