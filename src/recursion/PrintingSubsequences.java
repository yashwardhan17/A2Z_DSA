package recursion;

import java.util.ArrayList;

public class PrintingSubsequences {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        printSubsequences(0, res, arr, n);
    }

    static void printSubsequences (int index, ArrayList<Integer> res, int[] arr, int n) {
        if (index >= n) {
            System.out.println(res);
            return;
        }

        // take
        res.add(arr[index]);
        printSubsequences(index + 1, res, arr, n);
        // not take : backtrack
        res.remove(res.size() - 1);
        printSubsequences(index + 1, res, arr, n);
    }
}
