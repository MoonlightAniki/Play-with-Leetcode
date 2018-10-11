import java.util.HashMap;
import java.util.Map;

// 409. Longest Palindrome
// https://leetcode.com/problems/longest-palindrome/
public class Solution409 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer req = entry.getValue();
            if (req % 2 == 0) {
                result += req;
            } else if (req > 2) {
                result += (req - 1);
            }
        }
        if (result < length) {
            ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution409 s = new Solution409();
        System.out.println(s.longestPalindrome("ccc"));
        System.out.println(s.longestPalindrome("abccccdd"));
    }
}
// Runtime: 16 ms, faster than 23.29% of Java online submissions for Longest Palindrome.
