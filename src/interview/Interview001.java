package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 小米面试题
// 美丽字符串：(1)字符串中所有字符出现的次数相等
//            (2)删除或者添加一个字符使所有字符出现的次数相等
// 满足以上条件之一的字符串称为美丽字符串
// "abcabc" 满足条件(1)
// "aabbccc" 满足条件(2)
// "aabbc" 满足条件(2)
public class Interview001 {
    public static boolean isBeautiful(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Character> bucket[] = new List[s.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            bucket[i] = new ArrayList<>();
        }
        for (Map.Entry<Character, Integer> en : freq.entrySet()) {
            bucket[en.getValue()].add(en.getKey());
        }
        int notEmptyCnt = 0;
        int index = -1;
        for (int i = 0; i < bucket.length; ++i) {
            if (bucket[i].size() != 0) {
                if (++notEmptyCnt == 3) {
                    return false;
                }
                if (index == -1) {
                    index = i;
                }
            }
        }
        if (notEmptyCnt == 0) {
            return false;
        }
        if (notEmptyCnt == 1) {
            return true;
        }
        // notEmptyCnt == 2
        if (bucket[index + 1].size() == 0) {
            return false;
        }
        return bucket[index].size() == 1 || bucket[index + 1].size() == 1;
    }

    public static void main(String[] args) {
        System.out.println(isBeautiful("aabbcc"));
        System.out.println(isBeautiful("aabbccc"));
        System.out.println(isBeautiful("aabbc"));
        System.out.println(isBeautiful("aaaaabbbbbccc"));
    }
}
