package Arrays_1D;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int n = arr.length;
        System.out.println(MaxSumUsingKadane(arr, n));
    }

    //T.C - O(n^3) //Brute Force
    static int MaxSum(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    //T.C - O(n^2)
    static int MaxSum2(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    //Kadane's Algo //T.C - O(n) //DP Approach?
    static int MaxSumUsingKadane2(int[] arr, int n){
        int curr = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // either extend previous subarray OR start new from arr[i]
            curr = Math.max(arr[i], curr + arr[i]);
            max = Math.max(max, curr);
        }
        return max;
    }

    //Kadane's Algo //T.C - O(n)
    static int MaxSumUsingKadane(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }
}
