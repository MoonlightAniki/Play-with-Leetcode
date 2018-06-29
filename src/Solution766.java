// 766. Toeplitz Matrix
// https://leetcode.com/problems/toeplitz-matrix/description/
/*
Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
 */
class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; ++i) {
            if (i == 0) {
                for (int j = 0; j < cols; ++j) {
                    int num = matrix[i][j];
                    for (int m = i + 1, n = j + 1; m < rows && n < cols; ++m, ++n) {
                        if (matrix[m][n] != num) {
                            return false;
                        }
                    }
                }
            } else {
                int num = matrix[i][0];
                for (int m = i + 1, n = 1; m < rows && n < cols; ++m, ++n) {
                    if (matrix[m][n] != num) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
