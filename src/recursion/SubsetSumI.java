package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetSumI {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.println(subsetSum(arr));
    }

    static List<Integer> subsetSum(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        findSubsetSum(0, arr, 0, ans);
        Collections.sort(ans);
        return ans;
    }

    static void findSubsetSum(int idx, int[] arr, int sum, List<Integer> sumSubset) {
        if (idx == arr.length ) {
            sumSubset.add(sum);
            return;
        }
        findSubsetSum(idx + 1, arr, sum + arr[idx], sumSubset);
        findSubsetSum(idx + 1, arr, sum, sumSubset);
    }
}
