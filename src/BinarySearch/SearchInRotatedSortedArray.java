package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,3};
        int n = arr.length;
        int target = 3;
        System.out.println(Search2(arr, n, target));
    }
    //O(nlogN)
    static int Search(int[] arr, int n, int target){
        int start = 0;
        int end = n-1;
        while(start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[start] <= arr[mid]) {
                if(arr[start] <= target && target < arr[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(arr[mid] < target && target <= arr[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    static int Search2(int[] arr, int n, int target){
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start + ((end - start) / 2);

            if (arr[mid] == target){
                return mid;
            } else if (arr[start] <= arr[mid]){
                if(target < arr[start] ||  target > arr[mid]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(target > arr[end] || target < arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
