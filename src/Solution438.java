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

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return res;
        }

        for (int i = 0; i + p.length() <= s.length(); ++i) {
            String substr = s.substring(i, i + p.length());
            if (isAnagram(substr, p)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isAnagram(String a, String b) {
        int[] freq = new int[26];
        for (char c : a.toCharArray()) {
            ++freq[c - 'a'];
        }
        for (char c : b.toCharArray()) {
            --freq[c - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Solution438 solution = new Solution438();
        System.out.println(solution.findAnagrams(s, p));
    }
}
// Runtime: 771 ms, faster than 1.24% of Java online submissions for Find All Anagrams in a String.
