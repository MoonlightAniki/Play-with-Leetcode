import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Solution022 {
    private List<String> result;

    // 回溯算法
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generateParenthesis("", 0, 0, n);
        return result;
    }

    // s 保存了此时由open个左括号和close个右括号组合成的字符串
    // open 左括号的个数
    // close 右括号的个数
    private void generateParenthesis(String s, int open, int close, int n) {
        if (open + close == 2 * n) {
            result.add(s);
            return;
        }
        if (open < n) {
            generateParenthesis(s + "(", open + 1, close, n);
        }
        if (close < open) {
            generateParenthesis(s + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        Solution022 s = new Solution022();
        System.out.println(s.generateParenthesis(2));
    }
}
