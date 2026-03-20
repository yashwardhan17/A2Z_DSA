package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combinations(n, k));
    }

    static List<List<Integer>> combinations (int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1, n, k, ans, new ArrayList<>());
        return ans;
    }

    static void findCombinations (int start, int n, int k, List<List<Integer>> ans, List<Integer> list) {
        // base case
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (list.size() > k) {
            return;
        }

        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            findCombinations(i + 1, n, k, ans, list);
            list.remove(list.size() - 1);
        }
    }
}

// let's understand this expression : n - (k - list.size()) + 1

// k - list.size() → how many more numbers we still need
// n - i + 1 → how many numbers are left from i to n

// we want : (remaining numbers >= numbers needed)

// so, n - i + 1 >= k - list.size()
// now solve for i :
// n - i + 1 >= needed
// n + 1 - needed >= i
// i <= n - needed + 1
// and that's where, this comes from -> i <= n - (k - list.size()) + 1

// it ensures that Only start combinations from positions where enough numbers are remaining to complete size k.

// we can also run the loop till n only and then we can do ->
// int remaining = n - i + 1;
// int needed = k - list.size();
// if (remaining < needed) break;

