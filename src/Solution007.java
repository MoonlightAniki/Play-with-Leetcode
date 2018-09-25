// 7. Reverse Integer
// https://leetcode.com/problems/reverse-integer/
public class Solution007 {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int sign = x > 0 ? 1 : -1;
        long num = Math.abs(x);
        long reverseNum = 0;
        while (num != 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }
        if (reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE) {
            return 0;
        }
        reverseNum *= sign;
        return (int) reverseNum;
    }

    public static void main(String[] args) {
        Solution007 s = new Solution007();
        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(120));
        System.out.println(s.reverse(1534236469));
        System.out.println(s.reverse(-2147483648));
    }
}
