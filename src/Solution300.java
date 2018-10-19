import java.util.Arrays;

// 300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/
/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Note:
    1. There may be more than one LIS combination, it is only necessary for you to return the length.
    2. Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];//dp[index]表示以nums[index]结尾的子序列的最大长度,dp[index]的最大值就是问题的解
        Arrays.fill(dp, 1);//初始条件下，dp[index]都等于1，因为每个元素本身构成一个长度为1的上升子序列
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution300 s = new Solution300();
        System.out.println(s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
// Runtime: 31 ms, faster than 16.11% of Java online submissions for Longest Increasing Subsequence.
