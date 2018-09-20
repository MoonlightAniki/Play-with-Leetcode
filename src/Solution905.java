import java.util.Arrays;

// 905. Sort Array By Parity
// https://leetcode.com/problems/sort-array-by-parity/
public class Solution905 {
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    public int[] sortArrayByParity2(int[] A) {
        if (A == null || A.length < 2) return A;
        int[] result = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        for (int k = 0; k < A.length; ++k) {
            if (A[k] % 2 == 0) {
                result[i] = A[k];
                ++i;
            } else {
                result[j] = A[k];
                --j;
            }
        }
        return result;
    }

    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length < 2) return A;
        int i = 0;
        int j = A.length - 1;
        while (true) {
            while (i < A.length && A[i] % 2 == 0 /*注意两个条件的顺序*/) ++i;
            while (j >= 0 && A[j] % 2 == 1) --j;
            if (i >= j) break;
            swap(A, i, j);
            ++i;
            --j;
        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 3};
        System.out.println(Arrays.toString(new Solution905().sortArrayByParity(a)));
    }
}
