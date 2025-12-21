package BinarySearch;

public class SmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int threshold = 6;
        int n = arr.length;
        System.out.println(smallestDivisor(arr, threshold, n));
    }
    static int calculateSum(int[] arr, int div, int threshold, int n){
        int sum = 0;
        for (int i : arr) {
            sum += (i + div - 1)/ div;
            if(sum > threshold) return sum;
        }
        return sum;
    }

    static int smallestDivisor(int[] arr, int threshold, int n){
        if(n > threshold) return -1;

        int start = 1;
        int end = findMaxElement(arr, n);

        while(start<=end){
            int mid = start + ((end - start)/2);
            if(calculateSum(arr, mid, threshold, n) <= threshold){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }

    static int findMaxElement(int[] arr, int n){
        int max = arr[0];
        for(int val : arr){
            max = Math.max(max, val);
        }
        return max;
    }
}
