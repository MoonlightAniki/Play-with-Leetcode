// 63. Unique Paths II
// https://leetcode.com/problems/unique-paths-ii/
public class Solution063 {
//    public int uniquePathsWithObstacles(int[][] p) {
//        int m = p.length;
//        assert m > 0;
//
//        int n = p[0].length;
//        assert n > 0;
//
//        int[][] nums = new int[m][n];
//
//        int index = m;
//        for (int i = 0; i < m; ++i) {
//            if (p[i][0] == 0) {
//                nums[i][0] = 1;
//            } else {
//                index = i;
//                break;
//            }
//        }
//        for (; index < m; ++index) {
//            nums[index][0] = 0;
//        }
//
//
//        index = n;
//        for (int j = 0; j < n; ++j) {
//            if (p[0][j] == 0) {
//                nums[0][j] = 1;
//            } else {
//                index = j;
//                break;
//            }
//        }
//        for (; index < n; ++index) {
//            nums[0][index] = 0;
//        }
//
//        for (int i = 1; i < m; ++i) {
//            for (int j = 1; j < n; ++j) {
//                if (p[i][j] == 1) {
//                    nums[i][j] = 0;
//                } else {
//                    nums[i][j] = nums[i][j - 1] + nums[i - 1][j];
//                }
//            }
//        }
//
//        return nums[m - 1][n - 1];
//    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = 1;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution063 s = new Solution063();
//        int[][] p = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
        int[][] p = new int[][]{
                {1, 0}
        };
        System.out.println(s.uniquePathsWithObstacles(p));
    }
}
