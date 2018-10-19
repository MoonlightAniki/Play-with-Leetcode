import java.util.Arrays;

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
public class Solution416_V2 {

    private int[][] memo;

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
        int c = sum / 2;
        memo = new int[nums.length][c + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return tryPartition(nums, 0, c);
    }

    // 考虑从nums[index...n)中取出任意数量的元素，使得这些元素的和等于c
    private boolean tryPartition(int[] nums, int index, int c) {
        if (c < 0 || index >= nums.length) {
            return false;
        }
        if (c == 0) {
            return true;
        }
        if (memo[index][c] != -1) {
            return memo[index][c] == 1;
        }
        memo[index][c] = (tryPartition(nums, index + 1, c) || tryPartition(nums, index + 1, c - nums[index])) ? 1 : 0;
        return memo[index][c] == 1;
    }

    public static void main(String[] args) {
        Solution416_V2 s = new Solution416_V2();
        System.out.println(s.canPartition(new int[]{1, 5, 5, 11}));
        System.out.println(s.canPartition(new int[]{1, 2, 5}));

//        int[] nums = new int[100];
//        Arrays.fill(nums, 100);
//        System.out.println(s.canPartition(nums));
    }
}
