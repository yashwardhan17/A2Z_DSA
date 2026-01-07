package Arrays_2D;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Time Complexity: O(rows × cols)
    // Space Complexity: O(rows + cols)
    static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] rowCnt = new boolean[rows];
        boolean[] colCnt = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowCnt[i] = true;
                    colCnt[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowCnt[i] || colCnt[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void setZeroesOptimal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

    //    boolean[] rowCnt = new boolean[rows];  -> matrix[..][0]
    //    boolean[] colCnt = new boolean[cols];  -> matrix[0][..]

        int col0 = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // mark the i-th row
                    matrix[i][0] = 0;
                    // mark the j-th col
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }


                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

            }
        }

    }
}
