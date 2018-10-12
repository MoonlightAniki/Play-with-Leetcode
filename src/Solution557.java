// 557. Reverse Words in a String III
// https://leetcode.com/problems/reverse-words-in-a-string-iii/
/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class Solution557 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; ++i) {
            result.append(new StringBuilder(split[i]).reverse());
            if (i != split.length - 1) {
                result.append(' ');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution557 s = new Solution557();
        System.out.println(s.reverseWords("Let's take LeetCode contest"));
    }
}
// Runtime: 9 ms, faster than 76.58% of Java online submissions for Reverse Words in a String III.
