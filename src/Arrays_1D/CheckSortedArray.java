package arrays_1d;

public class CheckSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 6, 10, 12};
        int n = arr.length;
        System.out.println(check(arr, n));
    }
    //O(n) - optimal appraoch
    static boolean check(int[] arr, int n){
        if(n == 0 || n == 1) return true;
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if(arr[i] < arr[i-1]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    static boolean checkSortedAndRotated (int[] arr, int n) {
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                cnt++;
            }
        }

        if (arr[n-1] > arr[0]) {
            cnt++;
        }

        return cnt <= 1;
    }
}
