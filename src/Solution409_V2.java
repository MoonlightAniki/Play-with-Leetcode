public class Solution409_V2 {
    public int longestPalindrome(String s) {
        int[] req = new int[256];
        for (char c : s.toCharArray()) {
            ++req[c];
        }
        int res = 0;
        for (int i : req) {
            res += (i / 2) * 2;
        }
        if (res < s.length()) {
            ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution409_V2 s = new Solution409_V2();
        System.out.println(s.longestPalindrome("ccc"));
        System.out.println(s.longestPalindrome("abccccdd"));
    }
}
// Runtime: 5 ms, faster than 100.00% of Java online submissions for Longest Palindrome.
