// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int left = 0;
        int right = 0;//s[left...right]中无重复字符，滑动窗口
        int res = 1;
        String cur;
        while (left <= right && right < len) {
            cur = s.substring(left, right + 1);
            // 直到right==len-1或出现一个重复字符时停止循环
            while (right + 1 < len && cur.indexOf(s.charAt(right + 1)) == -1) {
                ++right;
                cur = s.substring(left, right + 1);
            }
            if (res < cur.length()) {
                res = cur.length();
            }
            if (right == len - 1) {
                break;
            }
            left = s.substring(0, right + 1).lastIndexOf(s.charAt(right + 1)) + 1;
            ++right;
        }
        return res;
    }

//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() <= 1) {
//            return s.length();
//        }
//        int left = 0;
//        int right = 1;
//        String max = s.substring(left, right);
//        String curr = s.substring(left, right);
//        while (right < s.length()) {
//            //curr = s.substring(left,right);
//            if (curr.indexOf(s.charAt(right)) == -1) {
//                right++;
//            } else {
//                //curr = s.substring(left,right);
//                //System.out.println(curr);
//                //max = max.length()>curr.length()? max:curr;
//                left = left + 1 + curr.indexOf(s.charAt(right));
//                right++;
//            }
//            curr = s.substring(left, right);
//            max = max.length() > curr.length() ? max : curr;
//        }
//        return max.length();
//    }

    public static void main(String[] args) {
        Solution003 s = new Solution003();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}
