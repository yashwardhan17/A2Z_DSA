package BinarySearch;

public class SingleElementSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        int n = arr.length;
        System.out.println(SingleElement(arr, n));
    }
    static int SingleElement(int[] arr, int n){
        if(n == 1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-2]) return arr[n-1];

        int start = 1;
        int end = n - 2;

        while (start <= end){
            int mid = start + ((end-start)/2);

            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]){
                return arr[mid];
            } else if ((mid % 2 == 1 && arr[mid-1] == arr[mid]) || (mid % 2 == 0 && arr[mid+1] == arr[mid])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
