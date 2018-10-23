import java.util.Arrays;

// 66. Plus One
// https://leetcode.com/problems/plus-one/
/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class Solution066_V3 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        Solution066_V3 s = new Solution066_V3();
        System.out.println(Arrays.toString(s.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{3, 9, 9, 9})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
