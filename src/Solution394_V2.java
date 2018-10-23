import java.util.Stack;

// 394. Decode String
// https://leetcode.com/problems/decode-string/
/*
Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat
numbers, k. For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Solution394_V2 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int index = 0;
        while (index < s.length()) {
            System.out.println("countStack:" + countStack + ", resStack:" + resStack + ", res:" + res);
            // 数字
            if (isDigit(s.charAt(index))) {
                int count = 0;
                while (isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    ++index;
                }
                countStack.push(count);
            }
            // 左括号
            else if (s.charAt(index) == '[') {
                resStack.push(res);
                res = "";
                ++index;
            }
            // 右括号
            else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; ++i) {
                    temp.append(res);
                }
                res = temp.toString();
                ++index;
            }
            // 字母
            else {
                res += s.charAt(index);
                ++index;
            }
        }
        return res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution394_V2 s = new Solution394_V2();
        System.out.println(s.decodeString("3[a2[c]]").equals("accaccacc"));
//        System.out.println(s.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
    }
}
// Runtime: 4 ms, faster than 23.69% of Java online submissions for Decode String.
