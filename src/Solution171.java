// 171. Excel Sheet Column Number
// https://leetcode.com/problems/excel-sheet-column-number/
/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26

    AA -> 27
    AB -> 28
    ...

Example 1:
Input: "A"
Output: 1

Example 2:
Input: "AB"
Output: 28

Example 3:
Input: "ZY"
Output: 701
 */
public class Solution171 {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution171 s = new Solution171();
        System.out.println(s.titleToNumber("AB"));
        System.out.println(s.titleToNumber("ZY"));
    }
}
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
