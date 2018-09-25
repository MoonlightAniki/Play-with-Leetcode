//5. Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/
public class Solution005 {

    // 暴力解法
//    public String longestPalindrome(String s) {
//        for (int len = s.length(); len >= 1; --len) {
//            for (int i = 0; i <= s.length() - len; ++i) {
//                if (isPalindrome(s.substring(i, i + len))) {
//                    return s.substring(i, i + len);
//                }
//            }
//        }
//        return "";
//    }
//
//    private boolean isPalindrome(String s) {
//        if (s == null || s.length() == 0) {
//            return false;
//        }
//        if (s.length() == 1) {
//            return true;
//        }
//        for (int begin = 0, end = s.length() - 1; begin < end; ++begin, --end) {
//            if (s.charAt(begin) != s.charAt(end)) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 时间复杂度为O(n^2)
    public String longestPalindrome(String s) {
        if (s == null) return null;
        int n = s.length();
        if (n == 0) return "";
        if (n == 1) return s;
        String longest = "";
        String p = null;
        for (int i = 0; i < n; ++i) {
            p = findPalindrome(s, i, i);//将s.charAt(i)作为p的中心点，长度为奇数
            if (p.length() > longest.length()) longest = p;
            p = findPalindrome(s, i, i + 1);//将s.charAt(i)和s.charAt(i+1)作为p的中心点，长度为偶数
            if (p.length() > longest.length()) longest = p;
        }
        return longest;
    }

    private String findPalindrome(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        Solution005 s = new Solution005();
        System.out.println(s.longestPalindrome("bababd"));
    }
}
