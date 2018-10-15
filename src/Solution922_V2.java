import java.util.Arrays;

public class Solution922_V2 {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int even = 0;
        int odd = 1;
        while (true) {
            while (even < A.length - 1 && A[even] % 2 == 0) {
                even += 2;
            }
            while (odd < A.length && A[odd] % 2 == 1) {
                odd += 2;
            }
            if (even >= A.length || odd >= A.length) {
                break;
            }
            swap(A, odd, even);
            odd += 2;
            even += 2;
        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution922_V2 s = new Solution922_V2();
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{1, 2, 3, 4})));
    }
}
// Runtime: 8 ms, faster than 100.00% of Java online submissions for Sort Array By Parity II.
