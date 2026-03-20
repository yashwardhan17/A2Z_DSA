package arrays_1d;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 3;
        System.out.println(generate(numRows));
        System.out.println(generateNthRow(numRows));
    }


    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[] row = new int[numRows];

        for (int i = 0; i < numRows; i++) {
            row[i] = 1;

            for (int j = i - 1; j > 0; j--) {
                row[j] = row[j] + row[j - 1];
            }

            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                temp.add(row[j]);
            }
            result.add(temp);
        }

        return result;
    }

    // generating a entire nth row
    // revise and leetcode (119) is 0 based indexing so revise this one
    static List<Integer> generateNthRow(int numRows) {
        List<Integer> res = new ArrayList<>();

        int val = 1;
        res.add(val);

        for (int i = 1; i < numRows; i++) {
            val = val * (numRows - i);
            val = val / i;
            res.add(val);
        }
        return res;
    }

    // Given row and colm
    // find the value
    // we can use nCr : n = n - 1 & r = r - 1
    // so we will do (n-1)C(r-1)

}
