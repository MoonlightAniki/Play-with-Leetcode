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
public class Solution198_V4 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int preMax = nums[0];
        int curMax = Math.max(preMax, nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            int temp = curMax;
            curMax = Math.max(nums[i] + preMax, curMax);
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        Solution198_V4 s = new Solution198_V4();
//        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(s.rob(nums));
    }
}
// Runtime: 5 ms, faster than 30.59% of Java online submissions for House Robber.
