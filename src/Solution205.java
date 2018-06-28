import java.util.HashMap;
import java.util.Map;

// 205. Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings/description/
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!sMap.containsKey(sChar)) {
                sMap.put(sChar, tChar);
            }
            if (!tMap.containsKey(tChar)) {
                tMap.put(tChar, sChar);
            }
            if (sMap.get(sChar) != tChar || tMap.get(tChar) != sChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 s = new Solution205();
        System.out.println(s.isIsomorphic("egg", "add"));
        System.out.println(s.isIsomorphic("foo", "var"));
    }
}
