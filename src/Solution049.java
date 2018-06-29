import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/description/
class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();//value是str所属anagram在result中的索引
        for (int i = 0; i < strs.length; ++i) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            str = new String(chars);
            if (map.containsKey(str)) {
                result.get(map.get(str)).add(strs[i]);
            } else {
                map.put(str, result.size());
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.add(list);
            }
        }
        return result;
    }

    private boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[128];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        for (char c : t.toCharArray()) {
            if (hash[c] == 0) {
                return false;
            }
            hash[c]--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution049 s = new Solution049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(strs));

        String[] strs2 = {"tea", "and", "ace", "ad", "eat", "dans"};
        System.out.println(s.groupAnagrams(strs2));
    }
}
