// 438. Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.ArrayList;
import java.util.List;

public class Solution438_V2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return res;
        }
        int[] freq_p = new int[26];
        for (char c : p.toCharArray()) {
            ++freq_p[c - 'a'];
        }
        int l = 0;
        int r = -1;//滑动窗口 [l...r]
        int[] freq_s = new int[26];
        while (r + 1 < s.length()) {
            ++r;
            ++freq_s[s.charAt(r) - 'a'];
            if (r - l + 1 > p.length()) {
                --freq_s[s.charAt(l++) - 'a'];
            }
            if (r - l + 1 == p.length() && same(freq_s, freq_p)) {
                res.add(l);
            }
        }
        return res;
    }

    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Solution438_V2 solution = new Solution438_V2();
        System.out.println(solution.findAnagrams(s, p));
    }
}
// Runtime: 11 ms, faster than 84.33% of Java online submissions for Find All Anagrams in a String.
