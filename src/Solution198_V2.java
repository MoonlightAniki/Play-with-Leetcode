// 198. House Robber
// https://leetcode.com/problems/house-robber/description/
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class Solution198_V2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // memo[index]表示考虑从nums[index...n)偷取财物的最大值
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            // 两种方案
            // 1.偷取i
            // 2.不偷取i
            memo[i] = Math.max(
                    nums[i] + (i + 2 >= n ? 0 : memo[i + 2]),//偷取i位置的财物
                    memo[i + 1]//不偷取i位置的财物
            );
        }
        return memo[0];
    }

    public static void main(String[] args) {
        Solution198_V2 s = new Solution198_V2();
//        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(s.rob(nums));
    }
}
// Runtime: 3 ms, faster than 100.00% of Java online submissions for House Robber.
