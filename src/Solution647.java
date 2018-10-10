// 647. Palindromic Substrings
// https://leetcode.com/problems/palindromic-substrings/
public class Solution647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int len = 1; len <= s.length(); ++len) {
            for (int i = 0; i + len <= s.length(); ++i) {
                if (isPalindrome(s.substring(i, i + len))) {
                    ++count;
                }
            }
        }
        return count;
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
        Solution647 s = new Solution647();
        System.out.println(s.countSubstrings("aaa"));
    }
}
// Runtime: 223 ms, faster than 7.76% of Java online submissions for Palindromic Substrings.
