import java.util.HashMap;
import java.util.Map;

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
public class Solution560_V2 {
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> record = new HashMap<>();//保存nums[0...i-1]范围元素的和的频次
        record.put(0, 1);
        int sum = 0;//nums[i...j]范围内元素的和, nums[i...j] = nums[0...j] - nums[0...i-1]
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (record.containsKey(sum - k)) {
                res += record.get(sum - k);
            }
            record.put(sum, record.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution560_V2 s = new Solution560_V2();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum(new int[]{1, -1, 1, -1, 1}, 0));
    }
}
// Runtime: 24 ms, faster than 63.65% of Java online submissions for Subarray Sum Equals K.
