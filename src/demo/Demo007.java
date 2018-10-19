package demo;

import java.util.ArrayList;
import java.util.List;

// 顺时针遍历数组
public class Demo007 {
    private final int[][] direction = {
            {0, 1},     // 向右
            {1, 0},     // 向下
            {0, -1},    // 向左
            {-1, 0}     // 向上
    };

    private int d = 0;//当前遍历的方向

    private int m, n;


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
            if (!visited[row][col]) {
                res.add(arr[row][col]);
                visited[row][col] = true;
            }

            int newR = row + direction[d][0];
            int newC = col + direction[d][1];

            if (inArea(newR, newC) && !visited[newR][newC]) {
                row = newR;
                col = newC;
            } else {
                d = (d + 1) % 4;//转向
                newR = row + direction[d][0];
                newC = col + direction[d][1];
                if (inArea(newR, newC) && !visited[newR][newC]) {
                    row = newR;
                    col = newC;
                } else {
                    break;//转向后依旧不能继续下去说明已经遍历完了所有元素
                }
            }
        }
        return res;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public static void main(String[] args) {
        Demo007 d = new Demo007();
//        int[][] arr = {
//                {1, 2, 3},
//                {8, 9, 4},
//                {7, 6, 5},
//        };

        int[][] arr = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        };
        System.out.println(d.traverse(arr));
    }
}
