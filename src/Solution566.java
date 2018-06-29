import java.util.Arrays;

// 566. Reshape the Matrix
// https://leetcode.com/problems/reshape-the-matrix/description/
class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return nums;
        }
        int rows = nums.length;
        int cols = nums[0].length;
        if (rows * cols != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int curR = 0;
        int curC = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                res[i][j] = nums[curR][curC];
                if (curC == cols - 1) {
                    curC = 0;
                    ++curR;
                } else {
                    ++curC;
                }
            }
        }
        return res;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        if (nums == null) {
            return nums;
        }
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                res[i][j] = nums[index / col][index % col];
                ++index;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution566 s = new Solution566();
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] result = s.matrixReshape2(nums, 1, 4);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
