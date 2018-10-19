// 494. Target Sum
// https://leetcode.com/problems/target-sum/
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5

Explanation:
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:
1. The length of the given array is positive and will not exceed 20.
2. The sum of elements in the given array will not exceed 1000.
3. Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class Solution494_V3 {
    // 问题就是找到数组的一个子数组 A 和剩余元素组成的另一个子数组 B，使得 sum(A) - sum(B) = sum
    // 等式两边同时加上 sum(A) + sum(B)
    // ===> sum(A) + sum(B) + sum(A) - sum(B) = sum(A) + sum(B) + sum
    // ===> 2sum(A) = sum(nums)+sum
    // ===> sum(A) == (sum(nums)+sum)/2 (需要保证sum(nums)+sum为偶数)
    // 这就是一个0-1背包问题，从nums中取出任意个元素填充容量为(sum(nums)+sum)/2的空间
    public int findTargetSumWays(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
        }
        if (s < sum) {
            return 0;
        }
        if ((s + sum) % 2 == 1) {
            return 0;
        }
        int C = (s + sum) / 2;
        return subsetSum(nums, C);
    }

    private int subsetSum(int[] nums, int C) {
        int[] dp = new int[C + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = C; j >= nums[i]; --j) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        Solution494_V3 s = new Solution494_V3();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(s.findTargetSumWays(new int[]{1000}, -1000) == 1);
        System.out.println(s.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0) == 1048576);
    }
}
// Runtime: 11 ms, faster than 88.19% of Java online submissions for Target Sum.
