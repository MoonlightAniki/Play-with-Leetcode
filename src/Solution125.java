// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/description/
public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (!isAlphanumeric(s.charAt(i))) {
                i++;
            } else if (!isAlphanumeric(s.charAt(j))) {
                --j;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    ++i;
                    --j;
                }
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        Solution125 s = new Solution125();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println(s.isPalindrome("              "));

        System.out.println(s.isPalindrome("race a car"));
    }
}
