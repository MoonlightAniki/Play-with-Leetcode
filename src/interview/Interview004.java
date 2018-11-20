package interview;

import java.util.Arrays;

// 快手面试题
// 一个数组中只含有0和1，对数组进行排序
public class Interview004 {

    // 方法1：计数排序
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int zeros = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                ++zeros;
            }
        }
        for (int i = 0; i < zeros; ++i) {
            arr[i] = 0;
        }
        for (int i = zeros; i < arr.length; ++i) {
            arr[i] = 1;
        }
    }


    // 方法2：双指针
    public static void sort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int zero = 0;
        int one = arr.length - 1;
        while (true) {
            while (zero < arr.length && arr[zero] == 0) {
                ++zero;
            }
            while (one >= 0 && arr[one] == 1) {
                --one;
            }
            if (zero >= one) {
                break;
            }
            swap(arr, zero, one);
            ++zero;
            --one;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 1, 0, 1};
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
