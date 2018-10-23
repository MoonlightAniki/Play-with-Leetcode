import java.util.Arrays;
import java.util.Stack;

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
public class Solution066 {

    // 数组中元素数量比较大时超出digit的取值范围
    public int[] plusOne(int[] digits) {
        int digit = 0;
        for (int i = 0; i < digits.length; ++i) {
            digit = digit * 10 + digits[i];
        }
        ++digit;

        Stack<Integer> stack = new Stack<>();
        while (digit > 0) {
            stack.push(digit % 10);
            digit /= 10;
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution066 s = new Solution066();
        System.out.println(Arrays.toString(s.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }
}
