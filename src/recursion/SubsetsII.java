package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }

    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findAllSubsets(0, nums, ans, new ArrayList<>());
        return ans;
    }

    static void findAllSubsets(int idx, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            findAllSubsets(i + 1, nums, ans, list);
            list.remove(list.size() - 1);
        }
    }
}
