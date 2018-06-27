// 345. Reverse Vowels of a String
// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class Solution345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int i = 0;
        int j = len - 1;
        char[] chars = s.toCharArray();
        while (i <= j) {
            if (!isVowel(chars[i])) {
                ++i;
            } else if (!isVowel(chars[j])) {
                --j;
            } else {
                swap(chars, i, j);
                ++i;
                --j;
            }
        }
        return new String(chars);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        Solution345 s = new Solution345();
        System.out.println("holle".equals(s.reverseVowels("hello")));
        System.out.println("leotcede".equals(s.reverseVowels("leetcode")));
    }
}
