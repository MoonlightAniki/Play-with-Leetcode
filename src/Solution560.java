// 560. Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/
/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
    1. The length of the array is in range [1, 20,000].
    2. The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class Solution560 {
    // Time Complexity : O(n^2)
    // Space Complexity : O(n)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] sum = new int[nums.length + 1];// sum[index]表示nums[0...index-1]范围内元素的和
        sum[0] = 0;
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

//        System.out.println(Arrays.toString(sum));

        int count = 0;
        for (int hi = 0; hi < sum.length; ++hi) {
            for (int lo = 0; lo < hi; ++lo) {
                if (sum[hi] - sum[lo] == k) {
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution560 s = new Solution560();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum(new int[]{1, -1, 1, -1, 1}, 0));
    }
}
// Runtime: 227 ms, faster than 9.24% of Java online submissions for Subarray Sum Equals K.
