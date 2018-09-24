// 70. Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/
public class Solution070 {


    // 记忆化搜索 + 递归
//    private int[] memo;
//
//    public int climbStairs(int n) {
//        memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        return calWays(n);
//    }
//
//    private int calWays(int n) {
//        if (n == 0 || n == 1) return 1;
//        if (memo[n] == -1) {
//            memo[n] = calWays(n - 1) + calWays(n - 2);
//        }
//        return memo[n];
//    }


    // 动态规划
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; ++i) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution070 s = new Solution070();
        System.out.println(s.climbStairs(3));
    }
}
