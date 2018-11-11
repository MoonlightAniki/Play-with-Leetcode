// 79. Word Search
// https://leetcode.com/problems/word-search/
/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class Solution079 {
    private int m, n;
    private static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private boolean searchWord(char[][] borad, int x, int y, String word, int index) {
        if (index == word.length() - 1) {
            return word.charAt(index) == borad[x][y];
        }
        if (borad[x][y] != word.charAt(index)) {
            return false;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && searchWord(borad, newX, newY, word, index + 1)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }


    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        if (n == 0) return false;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (searchWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        Solution079 s = new Solution079();
        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));
        System.out.println(s.exist(board, "ABCB"));
    }
}
// Runtime: 11 ms, faster than 63.16% of Java online submissions for Word Search.
