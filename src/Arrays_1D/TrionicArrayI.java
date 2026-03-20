package arrays_1d;

public class TrionicArrayI {
    public static void main(String[] args) {
        int[] arr = {5,6,4,6,8,8,7};
        System.out.println(triSegment(arr));
    }

    static boolean triSegment(int[] arr) {
        int n = arr.length;
        if (arr[0] >= arr[1]) return false;

        int validTransition = 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == arr[i+1]) return false;
            if (arr[i] > arr[i-1] && arr[i] > arr[i + 1]) {
                validTransition++;
            } else if (arr[i] < arr[i-1] && arr[i] < arr[i + 1]) {
                validTransition++;
            }
        }
        return validTransition == 2;
    }





}
