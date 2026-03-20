package arrays_1d;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 10, 2};
        System.out.println(findLargest(arr));
        System.out.println(largest(arr));
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

    static int largest(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
