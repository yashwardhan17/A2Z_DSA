package Arrays_1D;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        int k = 5;
        System.out.println(maxFrequency(arr, k));
    }

    static int maxFrequency(int[] arr, int k){
        Arrays.sort(arr);
        int start = 0;
        int maxFreq = 1;
        long windowSum = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            while ((long) arr[end] * (end - start + 1) - windowSum > k) { //requiredOps = nums[end] * windowSize - windowSum
                windowSum -= arr[start];
                start++;
            }

            maxFreq = Math.max(maxFreq, end - start + 1);
        }

        return maxFreq;
    }
}
