import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// 200. Number of Islands
// https://leetcode.com/problems/number-of-islands/
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3
 */
public class Solution200_V3 {
    private int m, n;
    private boolean[][] visited;
    private static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ++res;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(x, y));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> front = q.poll();
            for (int i = 0; i < 4; ++i) {
                int newX = front.getKey() + d[i][0];
                int newY = front.getValue() + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                    visited[newX][newY] = true;
                    q.offer(new Pair<>(newX, newY));
                }
            }
        }
    }

}
// Runtime: 12 ms, faster than 10.74% of Java online submissions for Number of Islands.
