// 64. Minimum Path Sum
// https://leetcode.com/problems/minimum-path-sum/
public class Solution064 {
    // Time complexity: O(n^2)
    // Space Complexity: O(1)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            if (i == 0) {
                for (int j = 1; j < n; ++j) {
                    grid[i][j] += grid[i][j - 1];
                }
            } else {
                grid[i][0] += grid[i - 1][0];
                for (int j = 1; j < n; ++j) {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Solution064 s = new Solution064();
        System.out.println(s.minPathSum(grid));
    }
}
