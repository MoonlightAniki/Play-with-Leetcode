import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Solution017 {

    private static final Map<Character, List<String>> MAP = new HashMap<>();

    static {
        MAP.put('2', Arrays.asList("a", "b", "c"));
        MAP.put('3', Arrays.asList("d", "e", "f"));
        MAP.put('4', Arrays.asList("g", "h", "i"));
        MAP.put('5', Arrays.asList("j", "k", "l"));
        MAP.put('6', Arrays.asList("m", "n", "o"));
        MAP.put('7', Arrays.asList("p", "q", "r", "s"));
        MAP.put('8', Arrays.asList("t", "u", "v"));
        MAP.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        res.addAll(MAP.get(digits.charAt(0)));
        if (digits.length() == 1) {
            return res;
        }
        char[] chs = digits.toCharArray();
        for (int i = 1, len = digits.length(); i < len; ++i) {
            while (res.peek().length() == i) {
                String front = res.poll();
                for (String s : MAP.get(chs[i])) {
                    res.add(front + s);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution017 s = new Solution017();
        System.out.println(s.letterCombinations("26"));
        System.out.println(s.letterCombinations("262"));
    }
}
// Runtime: 3 ms, faster than 44.53% of Java online submissions for Letter Combinations of a Phone Number.
