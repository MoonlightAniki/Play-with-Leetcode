// 028. Implement strStr()
// https://leetcode.com/problems/implement-strstr/
/*
mplement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class Solution028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int aLen = haystack.length();
        int bLen = needle.length();
        if (aLen < bLen) {
            return -1;
        }

        for (int i = 0; i + bLen <= aLen; ++i) {
            if (haystack.substring(i, i + bLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution028 s = new Solution028();
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("aaaaa", "bba"));
        System.out.println(s.strStr("aabba", "bba"));
    }
}
// Runtime: 4 ms, faster than 97.59% of Java online submissions for Implement strStr().
