// 268. Missing Number
// https://leetcode.com/problems/missing-number/
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
Input: [3,0,1]
Output: 2

Example 2:
Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 1; i <= nums.length; ++i) {
            sum += i;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution268 s = new Solution268();
        System.out.println(s.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
