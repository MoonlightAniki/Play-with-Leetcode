package demo;

import java.util.Arrays;

// iHandy面试题
// 将整数 n 转成字符数组，不可以使用库函数(StringBuilder也属于库函数)
// 12345 转成 {'1', '2', '3', '4', '5'}
public class Demo010 {
    public static char[] toString(int n) {
        if (n == 0) {
            return new char[]{'0'};
        }
        int m = n > 0 ? n : -n;
        int count = n > 0 ? 0 : 1;

        int temp = m;
        while (temp > 0) {
            ++count;
            temp /= 10;
        }

        char[] res = new char[count];
        if (n < 0) {
            res[0] = '-';
        }
        int index = count - 1;
        while (m > 0) {
            res[index--] = (char) ('0' + m % 10);
            m /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(toString(12345)));
        System.out.println(Arrays.toString(toString(-12345)));
        System.out.println(Arrays.toString(toString(0)));
    }
}
