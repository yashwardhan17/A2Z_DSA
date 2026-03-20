package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations (0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    static void findCombinations (int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> combination) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(combination));
            }
            return;
        }

        if (arr[idx] <= target) {
            combination.add(arr[idx]);
            findCombinations(idx, arr, target - arr[idx], ans, combination);
            combination.remove(combination.size() - 1);
        }
        findCombinations(idx + 1, arr, target, ans, combination);
    }
}
