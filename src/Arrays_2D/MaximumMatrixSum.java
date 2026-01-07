package Arrays_2D;

public class MaximumMatrixSum {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println(maxMatrixSum(matrix));
    }
    static long maxMatrixSum(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        long totalSum = 0;
        int negCnt = 0;
        int minAbs = Integer.MAX_VALUE;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = matrix[i][j];
                totalSum += Math.abs(val);
                if (val < 0) {
                    negCnt++;
                }
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }

        if (negCnt % 2 == 1) {
            totalSum -= 2*minAbs;
        }
        return totalSum;
    }
}
