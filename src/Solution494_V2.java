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
public class Solution494_V2 {
    // backtrack
    // time complexity : O(2^n)
    // space complexity : O(n)
    public int findTargetSumWays(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dfs(nums, sum, 0, 0);
    }

    // nums[0...index]范围内元素添加正负号后的总和为res
    private int dfs(int[] nums, int sum, int index, int res) {
        if (index == nums.length) {
            return res == sum ? 1 : 0;
        }
        int ret = 0;
        ret += dfs(nums, sum, index + 1, res + nums[index]);
        ret += dfs(nums, sum, index + 1, res - nums[index]);
        return ret;
    }

    public static void main(String[] args) {
        Solution494_V2 s = new Solution494_V2();
        System.out.println(s.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(s.findTargetSumWays(new int[]{1, 0}, 1));
    }
}
//Runtime: 779 ms, faster than 7.63% of Java online submissions for Target Sum.
