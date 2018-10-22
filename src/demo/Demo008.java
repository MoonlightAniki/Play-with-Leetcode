package demo;

import java.util.ArrayList;
import java.util.List;

// 从第一个元素开始逆时针遍历数组
// Example:
// Input:
// {
//     {1, 2, 3},
//     {4, 5, 6},
//     {7, 8, 9},
// }
// Output:
// {1, 4, 7, 8, 9, 6, 3, 2, 5}
public class Demo008 {

    private static final int[][] direction = {
            {1, 0},     // Down
            {0, 1},     // Right
            {-1, 0},    // Up
            {0, -1},    // Left
    };

    private int d = 0;

    private int m, n;

    private boolean inArea(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public List<Integer> traverse(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return res;
        }

        m = arr.length;
        n = arr[0].length;
        boolean[][] visited = new boolean[m][n];

        int row = 0;
        int col = 0;
        while (true) {
            if (inArea(row, col) && !visited[row][col]) {
                res.add(arr[row][col]);
                visited[row][col] = true;
            }

            int newRow = row + direction[d][0];
            int newCol = col + direction[d][1];

            if (inArea(newRow, newCol) && !visited[newRow][newCol]) {
                row = newRow;
                col = newCol;
            } else {
                d = (d + 1) % 4;
                newRow = row + direction[d][0];
                newCol = col + direction[d][1];
                if (inArea(newRow, newCol) && !visited[newRow][newCol]) {
                    row = newRow;
                    col = newCol;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Demo008 d = new Demo008();
        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15},
        };
        System.out.println(d.traverse(matrix));
    }
}
