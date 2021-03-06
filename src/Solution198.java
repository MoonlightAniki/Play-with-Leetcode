import java.util.Arrays;

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
public class Solution198 {
    // 记忆化搜索+递归
    private int[] memo;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        memo = new int[nums.length];//memo[i]代表tryRob(nums, i)
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    // 考虑从nums[index...n-1]中偷取
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        memo[index] = Math.max(nums[index] + tryRob(nums, index + 2),//偷取i并考虑从nums[i+2...n-1]中偷取
                tryRob(nums, index + 1)//不偷取i，考虑从nums[i+1...n-1]中偷取
        );
        return memo[index];
    }

    public static void main(String[] args) {
        Solution198 s = new Solution198();
        int[] nums = new int[]{1, 2, 3, 1};
//        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(s.rob(nums));
    }
}
//Runtime: 5 ms, faster than 32.13% of Java online submissions for House Robber.
