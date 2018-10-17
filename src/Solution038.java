// 038. Count and Say
// https://leetcode.com/problems/count-and-say/
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
 */
public class Solution038 {
    public String countAndSay(int n) {
        String prev = "1";
        String res = "1";
        for (int i = 2; i <= n; ++i) {
            res = countAndSay(prev);
            prev = res;
        }
        return res;
    }

    private String countAndSay(String s) {
        StringBuilder res = new StringBuilder();
        char prev = ' ';
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != prev) {
                if (cur.length() > 0) {
                    res.append(cur.length()).append(prev);
                }
                cur = new StringBuilder();
            }
            cur.append(s.charAt(i));
            prev = s.charAt(i);
        }
        if (cur.length() > 0) {
            res.append(cur.length()).append(prev);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution038 s = new Solution038();
        System.out.println(s.countAndSay(5));
    }
}
// Runtime: 3 ms, faster than 81.40% of Java online submissions for Count and Say.
