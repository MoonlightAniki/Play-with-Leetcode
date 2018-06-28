// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/description/
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        int[] hash = new int[128];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        for (char c : t.toCharArray()) {
            if (hash[c] == 0) {
                return false;
            } else {
                hash[c]--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution242 solution = new Solution242();
        String s = "anagram", t = "nagaram";
        System.out.println(solution.isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(solution.isAnagram(s, t));
    }
}
