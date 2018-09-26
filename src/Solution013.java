import java.util.HashMap;
import java.util.Map;

// 13. Roman to Integer
// https://leetcode.com/problems/roman-to-integer/
public class Solution013 {

    private static final Map<String, Integer> MAP;

    static {
        MAP = new HashMap<>();
        MAP.put("I", 1);
        MAP.put("V", 5);
        MAP.put("X", 10);
        MAP.put("L", 50);
        MAP.put("C", 100);
        MAP.put("D", 500);
        MAP.put("M", 1000);

        MAP.put("IV", 4);
        MAP.put("IX", 9);
        MAP.put("XL", 40);
        MAP.put("XC", 90);
        MAP.put("CD", 400);
        MAP.put("CM", 900);
    }

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
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return MAP.get(s);
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 0; ) {
            if (i == 0) {
                res += MAP.get(s.substring(0, 1));
                --i;
                break;
            }
            int a = MAP.getOrDefault(s.substring(i - 1, i - 1 + 2), -1);//先检查i和i-1组成的字符串是否合法的罗马数字
            // s[i-1...i]不是合法的罗马数字，将s[i]转成int
            if (a == -1) {
                res += MAP.get(s.substring(i, i + 1));
                --i;
            }
            // s[i-1...i]是合法的罗马数字，将s[i-1...i]转成int
            else {
                res += a;
                i = i - 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution013 s = new Solution013();
        System.out.println(s.romanToInt("MMCMXCIX"));
    }
}
