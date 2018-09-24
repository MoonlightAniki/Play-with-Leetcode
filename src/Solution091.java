// 91. Decode Ways
// https://leetcode.com/problems/decode-ways/
public class Solution091 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        if (s.length() == 1) {
            return check(s.charAt(0));
        }

        int[] memo = new int[s.length()];
        memo[0] = check(s.charAt(0));
        memo[1] = check(s.charAt(0)) * check(s.charAt(1)) + check(s.charAt(0), s.charAt(1));
        for (int i = 2; i < s.length(); ++i) {
            if (check(s.charAt(i)) == 1) {
                memo[i] += memo[i - 1];
            }
            if (check(s.charAt(i - 1), s.charAt(i)) == 1) {
                memo[i] += memo[i - 2];
            }
        }
        return memo[s.length() - 1];
    }

    private int check(char c) {
        return (c >= '1' && c <= '9') ? 1 : 0;
    }

    private int check(char a, char b) {
        return (a == '1' || (a == '2' && b >= '0' && b <= '6')) ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution091 s = new Solution091();
        System.out.println(s.numDecodings("226"));
    }
}
