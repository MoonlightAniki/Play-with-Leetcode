// 12. Integer to Roman
// https://leetcode.com/problems/integer-to-roman/
public class Solution012 {
    // Solution 1
//    public String intToRoman(int num) {
//        StringBuilder res = new StringBuilder();
//        int[] divide = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        for (int i = 0; i < divide.length; ++i) {
//            int cnt = num / divide[i];
//            for (int j = 0; j < cnt; ++j) {
//                res.append(roman[i]);
//            }
//            num = num % divide[i];
//        }
//        return res.toString();
//    }

    /*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
     */
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};//千位(1000, 2000, 3000)
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//百位(100, 200, 300, 400, 500, 600, 700, 800, 900)
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//十位(10, 20, 30, 40, 50, 60, 70, 80, 90)
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//个位(1, 2, 3, 4, 5, 6, 7, 8, 9)
        return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
    }

    public static void main(String[] args) {
        Solution012 s = new Solution012();
        System.out.println(s.intToRoman(1990));
    }
}
