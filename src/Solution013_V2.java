import java.util.HashMap;
import java.util.Map;

public class Solution013_V2 {

    private static final Map<Character, Integer> SYMBOL_MAP = new HashMap<>();

    static {
        SYMBOL_MAP.put('I', 1);
        SYMBOL_MAP.put('V', 5);
        SYMBOL_MAP.put('X', 10);
        SYMBOL_MAP.put('L', 50);
        SYMBOL_MAP.put('C', 100);
        SYMBOL_MAP.put('D', 500);
        SYMBOL_MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chs = s.toCharArray();
        int preValue = 0;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            int curValue = SYMBOL_MAP.get(chs[i]);
            if (curValue >= preValue) {
                res += curValue;
            } else {
                res -= curValue;
            }

            preValue = curValue;
        }
        return res;
    }

    public static void main(String[] args) {
        // MMCMXCIX -- 2999
        Solution013_V2 s = new Solution013_V2();
        System.out.println(s.romanToInt("MMCMXCIX") == 2999);
        System.out.println(s.romanToInt("III") == 3);
        System.out.println(s.romanToInt("CM") == 900);
    }
}
