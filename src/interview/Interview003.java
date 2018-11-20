package interview;

import java.util.Arrays;
import java.util.Random;

// 小米面试题
// Time: 2018-11-19
public class Interview003 {

    // 1. Path Sum
    // leetcode原题
    // https://leetcode.com/problems/path-sum/


    // 2. 快速排序
    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        __quickSort(arr, 0, arr.length - 1);
    }

    private void __quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        __quickSort(arr, l, p - 1);
        __quickSort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        swap(arr, l, new Random().nextInt(r - l + 1) + l);
        int v = arr[l];
        int p = l;//arr[l+1...p]<v
        for (int i = l + 1; i <= r; ++i) {
            if (arr[i] < v) {
                swap(arr, p + 1, i);
                ++p;
            }
        }
        swap(arr, l, p);
        return p;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //=======================================================


    //3. 将一个十进制字符串转成int类型
    public int parseInt(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int sign = 1;
        if (s.startsWith("-")) {
            sign = -1;
            s = s.substring(1);
        } else if (s.startsWith("+")) {
            sign = 1;
            s = s.substring(1);
        }
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (!isDigit(s.charAt(i))) {
                throw new IllegalArgumentException();
            }
            res = 10 * res + (s.charAt(i) - '0');
        }
        return sign * res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    //=============================================================


    // 4.判断一个字符串是否能够通过添加一个字符成为回文串
    public boolean canPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i + 1, j + 1));
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 8, 7, 6, 5, 3, 4, 2, 1};
        Interview003 interview = new Interview003();
        interview.quickSort(arr);
        System.out.println(Arrays.toString(arr));


        System.out.println(interview.parseInt("+12345"));
        System.out.println(interview.parseInt("-12345"));
        System.out.println(interview.parseInt("0"));

        System.out.println(interview.canPalindrome("abca"));
        System.out.println(interview.canPalindrome("abcd"));
        System.out.println(interview.canPalindrome("abba"));
        System.out.println(interview.canPalindrome("abcba"));
    }
}
