package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int n = arr.length;
        int target = 2;
        System.out.println(SearchPos(arr, n, target));
    }

    //T.C = O(log N) S.C = O(1)
    static int SearchPos(int[] arr, int n, int target){
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
