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
public class Solution343_V3 {

    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int max = -1;
            for (int j = 1; j < i; ++j) {
                // 将 i 分成 j 和 (i-j)
                max = max(max, j * (i - j), j * memo[i - j]);
            }
            memo[i] = max;
        }
        return memo[n];
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Solution343_V3 s = new Solution343_V3();
        System.out.println(s.integerBreak(10));
    }
}
// Runtime: 1 ms, faster than 58.37% of Java online submissions for Integer Break.
