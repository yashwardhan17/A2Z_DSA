package Arrays_1D;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeS(arr);

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    // Better Soln
    // T.C = O(n^2)
    // S.C = O(N) + O(K) : N → for the HashSet used in 2Sum | K → number of unique triplets in the output
    // arr[k] = -(arr[i] + arr[j])
    // We will use a HashMap to store the elements which is between the i and j pointer
    // When my j reaches end, we will empty the HashMap again and move i++

    static List<List<Integer>> threeSum (int[] arr) {
        int n = arr.length;

        HashSet <List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            HashSet <Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if (set.contains(third)) {
                    List <Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                set.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
    }

    // Optimal Soln
    // 2 pointer approach
    // Time Complexity: O(N²) : O(N log N) {Sorting} + O(N²)
    // O(1)

    static List<List<Integer>> threeS (int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return ans;
    }
}
