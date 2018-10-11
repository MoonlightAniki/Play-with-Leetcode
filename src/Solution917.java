// 917. Reverse Only Letters
// https://leetcode.com/problems/reverse-only-letters/
/*
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:
    1. S.length <= 100
    2. 33 <= S[i].ASCIIcode <= 122
    3. S doesn't contain \ or "
 */
public class Solution917 {
    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int n = s.length();
        char[] chars = s.toCharArray();
        int l = 0;
        int r = n - 1;
        while (true) {
            while (l < n && !isLetter(chars[l])) {
                ++l;
            }
            while (r >= 0 && !isLetter(chars[r])) {
                --r;
            }
            if (l >= r) {
                break;
            }
            swap(chars, l, r);
            ++l;
            --r;
        }

        StringBuilder res = new StringBuilder();
        for (char c : chars) {
            res.append(c);
        }
        return res.toString();
    }

    private void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        Solution917 s = new Solution917();
        System.out.println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!").equals("Qedo1ct-eeLg=ntse-T!"));
    }
}
// Runtime: 7 ms, faster than 62.56% of Java online submissions for Reverse Only Letters.
