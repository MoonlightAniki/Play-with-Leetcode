public class Solution680_V2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                ++left;
                --right;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            ++left;
            --right;
        }
        return left >= right;
    }

    public static void main(String[] args) {
        Solution680_V2 s = new Solution680_V2();
        System.out.println(s.validPalindrome("aba"));
        System.out.println(s.validPalindrome("aabbcc"));
    }
}
// Runtime: 26 ms, faster than 63.05% of Java online submissions for Valid Palindrome II.
