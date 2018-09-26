// 14. Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/
public class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String minStr = strs[0];
        for (int i = 1, len = strs.length; i < len; ++i) {
            if (strs[i].length() < minStr.length()) {
                minStr = strs[i];
            }
        }

        for (int i = 0, len = strs.length; i < len; ++i) {
            if (!strs[i].startsWith(minStr)) {
                minStr = minStr.substring(0, minStr.length() - 1);
                --i;
                continue;
            }
        }

        return minStr;
    }


    public static void main(String[] args) {
        Solution014 s = new Solution014();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
