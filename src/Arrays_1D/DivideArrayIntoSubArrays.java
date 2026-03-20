package arrays_1d;

public class DivideArrayIntoSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 12};
        System.out.println(minCost(arr));
    }

    static int minCost (int[] arr) {
        int n = arr.length;
        int f = arr[0];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
            } else if (arr[i] < min2) {
                min2 = arr[i];
            }
        }
        return f + min1 + min2;
    }
}
