import java.util.HashMap;
import java.util.Map;

// 290. Word Pattern
// https://leetcode.com/problems/word-pattern/description/
public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        int size = pattern.length();
        String[] strs = str.split(" ");
        if (size != strs.length) {
            return false;
        }
        for (int i = 0; i < size; ++i) {
            char ch = pattern.charAt(i);
            String s = strs[i];
            if (!patternMap.containsKey(ch)) {
                patternMap.put(ch, s);
            }
            if (!strMap.containsKey(s)) {
                strMap.put(s, ch);
            }
            if (!s.equals(patternMap.get(ch)) || strMap.get(s) != ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        Solution290 s = new Solution290();
        System.out.println(s.wordPattern(pattern, str));
    }
}
