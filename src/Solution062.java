// 62. Unique Paths
// https://leetcode.com/problems/unique-paths/
public class Solution062 {
    public int uniquePaths(int m, int n) {
        int[][] p = new int[m][n];
        for (int j = 0; j < n; ++j) {
            p[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            p[i][0] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                p[i][j] = p[i - 1][j] + p[i][j - 1];
            }
        }
        return p[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution062 s = new Solution062();
        System.out.println(s.uniquePaths(3, 2));
    }
}
