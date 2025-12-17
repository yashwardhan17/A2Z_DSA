package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int n = arr.length;
        int target = 9;
        System.out.println(BS(arr, n, target));
    }

    //T.C = O(log n) & S.C = O(1)
    static int BS(int[] arr, int n, int target){
        int start = 0;
        int end = n - 1;
        while(start <= end){
            int mid = start + ((end-start)/2);
            if(target == arr[mid]){
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
