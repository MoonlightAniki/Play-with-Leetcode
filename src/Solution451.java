import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// 451. Sort Characters By Frequency
// https://leetcode.com/problems/sort-characters-by-frequency/description/
class Solution451 {

    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        Map<Character, Integer> record = new HashMap<>();
        for (char c : s.toCharArray()) {
            record.put(c, record.getOrDefault(c, 0) + 1);
        }
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.length() == a.length() ? a.compareTo(b) : b.length() - a.length();
            }
        });
        for (Map.Entry<Character, Integer> entry : record.entrySet()) {
            set.add(repeat(entry.getKey(), entry.getValue()));
        }
        StringBuilder res = new StringBuilder();
        for (String item : set) {
            res.append(item);
        }
        return res.toString();
    }

    public String repeat(char ch, int count) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution451 s = new Solution451();
        System.out.println(s.frequencySort("tree"));
        System.out.println(s.frequencySort("Aabb"));
        System.out.println(s.frequencySort("2a554442f544asfasssffffasss").equals("sssssssffffff44444aaaa55522"));
    }
}
