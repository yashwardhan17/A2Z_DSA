package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int size = 3;
        int target = 7;
        System.out.println(combinationSumIII(size, target));
    }

    static List<List<Integer>> combinationSumIII (int size, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1, size, target, ans, new ArrayList<>());
        return ans;   
    }

    static void findCombinations (int start, int requiredSize, int remainingTarget, List<List<Integer>> ans, List<Integer> list) {
        // base case
        if (remainingTarget == 0 && list.size() == requiredSize) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (remainingTarget < 0 || list.size() > requiredSize) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remainingTarget) break;
            list.add(i);
            findCombinations(i + 1, requiredSize, remainingTarget - i, ans, list);
            list.remove(list.size() - 1);
        }
    }
}
