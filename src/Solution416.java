// 416. Partition Equal Subset Sum
// https://leetcode.com/problems/partition-equal-subset-sum/
/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such
that the sum of elements in both subsets is equal.

Note:
    1. Each of the array element will not exceed 100.
    2. The array size will not exceed 200.

Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class Solution416 {

    // 问题等价于从nums中选取任意数量的元素，能否刚好填充sum/2的空间
    public boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int n = nums.length;
        int C = sum / 2;
        boolean[] dp = new boolean[C + 1];
        for (int j = 0; j <= C; ++j) {
            dp[j] = (nums[0] == j);
        }
        for (int i = 1; i < n; ++i) {
            for (int j = C; j >= nums[i]; --j) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        Solution416 s = new Solution416();
        System.out.println(s.canPartition(new int[]{1, 5, 5, 11}));
        System.out.println(s.canPartition(new int[]{1, 2, 5}));

//        int[] nums = new int[100];
//        Arrays.fill(nums, 100);
//        System.out.println(s.canPartition(nums));
    }
}
// Runtime: 17 ms, faster than 75.97% of Java online submissions for Partition Equal Subset Sum.
