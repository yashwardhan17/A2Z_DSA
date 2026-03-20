package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSumII(candidates, target));
    }

    static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    static void findCombinations(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> combination) {
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            combination.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
