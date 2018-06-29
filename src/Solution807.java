// 807. Max Increase to Keep City Skyline
// https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 找出每一行最高的建筑
        int rows = grid.length;
        int cols = grid[0].length;

        int[] h = new int[rows];//每一行的最大值
        for (int i = 0; i < rows; ++i) {
            int max = -1;
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            h[i] = max;
        }

        int[] v = new int[cols];//每一列的最大值
        for (int i = 0; i < cols; ++i) {
            int max = -1;
            for (int j = 0; j < rows; ++j) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            v[i] = max;
        }

        int sum = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] < Math.min(h[i], v[j])) {
                    sum += (Math.min(h[i], v[j]) - grid[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution807 s = new Solution807();
        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};
        int result = s.maxIncreaseKeepingSkyline(grid);
        System.out.println(result);
    }
}
