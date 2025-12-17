package BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        int n = arr.length;
        System.out.println(Peak(arr, n));
    }
    static int Peak(int[] arr, int n){
        int start=0;
        int end = n-1;

        while(start < end){
            int mid=start+((end-start)/2);

            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else {
                start=mid+1;
            }
        }
        return start;
    }
}
