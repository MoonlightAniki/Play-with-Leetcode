// 058. Length of Last Word
// https://leetcode.com/problems/length-of-last-word/
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5
 */
public class Solution058 {
    // // Runtime: 5 ms, faster than 43.10% of Java online submissions for Length of Last Word.
//    public int lengthOfLastWord(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int index = s.length() - 1;
//        while (index >= 0 && s.charAt(index) == ' ') {
//            --index;
//        }
//        int len = 0;
//        for (int i = index; i >= 0 && s.charAt(i) != ' '; --i) {
//            ++len;
//        }
//        return len;
//    }

    // Runtime: 3 ms, faster than 99.37% of Java online submissions for Length of Last Word.
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        int len = 0;
        for (int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; --i) {
            ++len;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution058 s = new Solution058();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord("a "));
        System.out.println(s.lengthOfLastWord("    "));
    }
}

