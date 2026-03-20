package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }

    // T.C = O(2^n * n) : Copying takes O(n) in worst case.
    static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        findAllSubsets(0, new ArrayList<>(), arr, ans);
        // findSubsets(0, new ArrayList<>(), arr, ans);
        return ans;
    }

    static void findAllSubsets(int index, List<Integer> res, int[] arr, List<List<Integer>> ans) {
        if (index == arr.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(arr[index]);
        findAllSubsets(index + 1, res, arr, ans);
        res.remove(res.size() - 1);
        findAllSubsets(index + 1, res, arr, ans);
    }

    static void findSubsets (int index, List<Integer> res, int[] arr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(res));
        for (int i = index; i < arr.length; i++) {
            res.add(arr[i]);
            findAllSubsets(i + 1, res, arr, ans);
            res.remove(res.size() - 1);
        }
    }
}
