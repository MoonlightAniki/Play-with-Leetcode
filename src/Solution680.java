// 680. Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/

/*

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

 */
public class Solution680 {

    // Time Limit Exceeded
    public boolean validPalindrome(String s) {
        long startTime = System.nanoTime();
        boolean result = false;
        for (int i = 0; i < s.length(); ++i) {
            if (isPalindrome(s.substring(0, i) + s.substring(i + 1))) {
                result = true;
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("time : " + (endTime - startTime) / 10000000000.0 + " s.");
        return result;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution680 s = new Solution680();
        System.out.println(s.validPalindrome("aba"));
    }
}
