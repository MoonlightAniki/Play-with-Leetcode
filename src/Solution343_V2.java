// 343. Integer Break
// https://leetcode.com/problems/integer-break/
/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:
Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:
Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Solution343_V2 {

    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return breakInteger(n);
    }

    // 将n分至少2份的最大乘积
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int max = -1;
        for (int i = 1; i < n; ++i) {
            // 将 n 分成 i 和 (n-i)
            max = max(max, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = max;
        return max;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Solution343_V2 s = new Solution343_V2();
        System.out.println(s.integerBreak(10));
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Break.
