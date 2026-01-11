package PrefixSum;

public class MaximumScoreOfASplit {
    public static void main(String[] args) {
        int[] arr = {10,-1,3,-4,-5};
        System.out.println(maxScore(arr));
    }

    //T.C and S.C = O(n) both
    static long maxScore (int[] arr){
        int n = arr.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }

        long prefixSum = 0;
        long maxScore = Long.MIN_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            prefixSum += arr[i];
            long score = prefixSum - suffixMin[i + 1];
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    //prefixSum always represents sum of 0 → i
    //rightMin always represents min of i+1 → end
    //T.C = O(n) and S.C = O(1)

    static long maxScoreWithoutSuffixArray(int[] arr){
        int n = arr.length;

        // Total sum of array
        long prefixSum = 0;
        for (int val : arr) prefixSum += val;

        long maxScore = Long.MIN_VALUE;
        int rightMin = arr[n - 1];

        // Move split from right to left
        for (int i = n - 2; i >= 0; i--) {

            // Remove current element from right part
            prefixSum -= arr[i + 1];

            // Update right minimum
            rightMin = Math.min(rightMin, arr[i + 1]);

            // Calculate score
            long score = prefixSum - rightMin;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
