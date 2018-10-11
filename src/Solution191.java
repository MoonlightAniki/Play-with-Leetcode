// 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/
/*
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011
Example 2:

Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 */
public class Solution191 {

    // Memory Limit Exceeded
    public int hammingWeight(int n) {
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            memo[i] = memo[i >> 1] + i % 2;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Solution191 s = new Solution191();
        System.out.println(s.hammingWeight(11));
        System.out.println(s.hammingWeight(128));
    }
}
//Runtime: 1 ms, faster than 99.04% of Java online submissions for Number of 1 Bits.
