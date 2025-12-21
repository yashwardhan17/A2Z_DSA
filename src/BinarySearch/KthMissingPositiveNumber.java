package BinarySearch;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int n = arr.length;
        int k = 5;
        System.out.println(missingNumberBrute(arr, n, k));
    }
    static int missingNumberBrute(int[] arr, int n, int k){
        for (int i = 0; i < n; i++) {
            if(arr[i] <= k){
                k++;
            } else {
                break;
            }
        }
        return k;
    }


}
