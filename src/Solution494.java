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
public class Solution494 {
    public int findTargetSumWays(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, 0, sum);
        return count;
    }

    private int count = 0;

    private void dfs(int[] nums, int index, int sum) {
        if (index == nums.length) {
            return;
        }
        if (index == nums.length - 1) {
            if (nums[index] == sum) {
                ++count;
            }
            if (-nums[index] == sum) {
                ++count;
            }
        }
        dfs(nums, index + 1, sum - nums[index]);
        dfs(nums, index + 1, sum + nums[index]);
    }

    public static void main(String[] args) {
        Solution494 s = new Solution494();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(s.findTargetSumWays(new int[]{1, 0}, 1));
    }
}
// Runtime: 433 ms, faster than 38.53% of Java online submissions for Target Sum.
