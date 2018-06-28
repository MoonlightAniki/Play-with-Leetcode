import java.util.Arrays;

// 832. Flipping an Image
// https://leetcode.com/problems/flipping-an-image/description/
class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int row = 0; row < A.length; ++row) {
            for (int start = 0, end = A[row].length - 1; start < end; ++start, --end) {
                swap(A[row], start, end);
            }
        }
        for (int row = 0; row < A.length; ++row) {
            for (int col = 0; col < A[row].length; ++col) {
                if (A[row][col] == 0) {
                    A[row][col] = 1;
                } else if (A[row][col] == 1) {
                    A[row][col] = 0;
                }
            }
        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution832 s = new Solution832();
        int[][] matrix = {{1, 1, 0}, {0, 0, 1}, {1, 0, 1}};
        matrix = s.flipAndInvertImage(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
