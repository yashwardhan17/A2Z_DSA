package Arrays_1D;

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
}
