import java.util.Arrays;

// 279. Perfect Squares
// https://leetcode.com/problems/perfect-squares/
public class Solution279 {

    // 记忆化搜索+递归
//    private int[] memo;
//
//    public int numSquares(int n) {
//        memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        return __numSquares(n);
//    }
//
//    private int __numSquares(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        if (memo[n] != -1) return memo[n];
//
//        int res = n;
//        for (int i = 1; i * i <= n; ++i) {
//            res = Math.min(res, __numSquares(n - i * i) + 1);
//        }
//        memo[n] = res;
//        return res;
//    }

    // 动态规划
    public int numSquares(int n) {
        // memo[i]表示 numSquares(n) 的结果
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int res = i;//最差的情况：由i个1组成
            for (int j = 1; j * j <= i; ++j) {
                res = Math.min(res, memo[i - j * j] + 1);
            }
            memo[i] = res;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution279 s = new Solution279();
        System.out.println(s.numSquares(13));
        System.out.println(s.numSquares(3));
        System.out.println(s.numSquares(12));
    }
}
