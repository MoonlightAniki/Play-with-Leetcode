// 9. Palindrome Number
// https://leetcode.com/problems/palindrome-number/
public class Solution009 {
//    public boolean isPalindrome(int x) {
//        String s = String.valueOf(x);
//        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = reverse(x);
        return reverse == x;
    }

    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Solution009 s = new Solution009();
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(-121));
    }
}
