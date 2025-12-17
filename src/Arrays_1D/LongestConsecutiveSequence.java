package Arrays_1D;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        int n = arr.length;
        System.out.println(LongConsSeq(arr,n));
    }

    //Using HashSet //T.C = O(n) //S.C = O(n)
    static int LongConsSeq(int[] arr, int n){
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int longest = 0;
        for(int i : set){
            if(!set.contains(i-1)){
                int curr = i;
                int count = 1;

                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    //T.C = O(n log n) //S.C = O(1)
    static int LongSequence(int[] arr, int n){
        Arrays.sort(arr);
        int longest = 1;
        int cnt = 1;
        int lastSmaller = arr[0];

        if(n == 0) return 0;

        for (int i = 1; i < n; i++) {
            if(arr[i] == lastSmaller + 1){
                cnt++;
                lastSmaller = arr[i];
            } else if (lastSmaller != arr[i]) {
                cnt = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }

    //Brute Force //T.C = O(n^3) and S.C = O(1)
    static int LongestSequence(int[] arr, int n){
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 1;
            while(LinearSearch(arr, x + 1)){
                x++;
                count++;
            }
            longest = Math.max(count, longest);
        }
        return longest;
    }

    static boolean LinearSearch(int[] arr, int target) {
        if (arr.length==0) {
            return false;
        }
        for (int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }
}
