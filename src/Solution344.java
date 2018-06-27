// 344. Reverse String
// https://leetcode.com/problems/reverse-string/description/
public class Solution344 {
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder().append(s).reverse().toString();
    }
}
