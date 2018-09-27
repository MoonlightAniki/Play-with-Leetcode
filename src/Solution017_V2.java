import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. Letter Combination of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Solution017_V2 {

    private static final Map<Character, String> letterMap = new HashMap<>();

    static {
        letterMap.put('0', " ");
        letterMap.put('1', "");
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
    }

    private List<String> result;

    // 回溯算法(Backtracking)
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        findCombination(digits, 0, "");
        return result;
    }

    // s 保存了此时从digits[0...index-1]组合得到的一个字符串，寻找与digits[index]匹配的字母，获得digits[0...index]组合得到的解
    private void findCombination(String digits, int index, String s) {

        // 已经考察完所有的数字
        if (index == digits.length()) {
            result.add(s);
            return;
        }

        char ch = digits.charAt(index);
        assert ch >= '2' && ch <= '9';
        String letters = letterMap.get(ch);
        for (int i = 0, len = letters.length(); i < len; ++i) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution017_V2 s = new Solution017_V2();
        System.out.println(s.letterCombinations("269"));
    }
}
// Runtime: 3 ms, faster than 44.53% of Java online submissions for Letter Combinations of a Phone Number.
