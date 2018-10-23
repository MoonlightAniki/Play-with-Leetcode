// 387. First Unique Character in a String
// https://leetcode.com/problems/first-unique-character-in-a-string/
/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            ++freq[c];
        }
        for (int i = 0; i < s.length(); ++i) {
            if (freq[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution387 s = new Solution387();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }
}
// Runtime: 11 ms, faster than 94.13% of Java online submissions for First Unique Character in a String.
