public class Solution647_V2 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0, len = s.length(); i < len; ++i) {
            count += findPalindromes(s, len, i, i);// 以s[i]为中心的回文串
            if (i + 1 < len) {
                count += findPalindromes(s, len, i, i + 1);//以s[i]和s[i+1]两个字符为中心的回文串
            }
        }
        return count;
    }

    private int findPalindromes(String s, int len, int l, int r) {
        int count = 0;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution647_V2 s = new Solution647_V2();
        System.out.println(s.countSubstrings("aaa"));
    }
}
// Runtime: 14 ms, faster than 50.87% of Java online submissions for Palindromic Substrings.
