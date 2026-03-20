package recursion;

import java.util.ArrayList;

public class PrintSubsequencesWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int n = arr.length;
        int k = 2;
        ArrayList<Integer> res = new ArrayList<>();
        subsequencesWithSumK(0, res, arr, 0, k, n);
        anySubsequenceWithSumK(0, res, arr, 0, k, n);
        System.out.println(countSubsequencesWithSumK(0, arr, 0, k, n));
    }

    static void subsequencesWithSumK (int index, ArrayList<Integer> res, int[] arr, int sum, int k, int n) {
        if (index == n) {
            if (sum == k) {
                System.out.println(res);
            }
            return;
        }

        // Take
        res.add(arr[index]);
        // sum += arr[index];
        // subsequencesWithSumK(index + 1, res, arr, sum, k, n);

        // Java is Pass-by-Value for primitives like int etc -> copy of sum is passed : the original sum remainds unchanged.
        subsequencesWithSumK(index + 1, res, arr, sum + arr[index], k, n);

        // Not take case
        // Objects are passed as reference value. (here res is an object : ArrayList) -> so it modifies the List.
        res.remove(res.size() - 1);
        // sum -= arr[index];
        subsequencesWithSumK(index + 1, res, arr, sum, k, n);
    }

    static boolean anySubsequenceWithSumK (int index, ArrayList<Integer> res, int[] arr, int sum, int k, int n) {
        if (index == n) {
            if (sum == k) {
                System.out.println(res);
                return true; // condition satisfied
            }
            return false; // condition not satisfied
        }

        // Take
        res.add(arr[index]);
        if (anySubsequenceWithSumK(index + 1, res, arr, sum + arr[index], k, n) == true) {
            return true;
        }

        res.remove(res.size() - 1);
        if (anySubsequenceWithSumK(index + 1, res, arr, sum, k, n) == true) {
            return true;
        }
        return false;
    }

    static int countSubsequencesWithSumK (int index, int[] arr, int sum, int k, int n) {
        if (index == n) {
            if (sum == k) {
                // System.out.println(res);  -> no need to print it here
                return 1; // condition satisfied
            }
            return 0; // condition not satisfied
        }

        int left = countSubsequencesWithSumK(index + 1, arr, sum + arr[index], k, n);

        int right = countSubsequencesWithSumK(index + 1, arr, sum, k, n);

        return left + right;
    }
}
// summary
// print all -> parameter wise
// print one -> return T/F : avoid further recursion calls if I get true
// count -> return 1 or 0 : add all f() and then return
