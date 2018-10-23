import java.util.ArrayList;
import java.util.List;
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
public class Solution394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {

                // 获取字符部分encoded_string
                String temp = "";
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp = stack.pop() + temp;
                }
                // 使用StringBuilder.insert来拼接字符串效率不如直接使用加号拼接字符串
                // Runtime: 8 ms, faster than 4.24% of Java online submissions for Decode String.
//                StringBuilder temp = new StringBuilder();
//                while (!stack.isEmpty() && stack.peek() != '[') {
//                    temp.insert(0, stack.pop());
//                }

                // 将左括号pop出栈
                stack.pop();

                // 获取重复次数k
                int repeat = 0;
                int weight = 1;
                while (!stack.isEmpty() && isDigit(stack.peek())) {
                    repeat += (stack.pop() - '0') * weight;
                    weight *= 10;
                }

                // 将k[encoded_string]重新push进栈中
                for (int i = 0; i < repeat; ++i) {
                    for (char ch : temp.toCharArray()) {
                        stack.push(ch);
                    }
                }
            } else {
                stack.push(c);
            }
        }

        List<Character> list = new ArrayList<>(stack);
        StringBuilder res = new StringBuilder();
        for (Character c : list) {
            res.append(c);
        }
        return res.toString();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution394 s = new Solution394();
        System.out.println(s.decodeString("3[a2[c]]").equals("accaccacc"));
        System.out.println(s.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
    }
}
// Runtime: 4 ms, faster than 23.69% of Java online submissions for Decode String.
