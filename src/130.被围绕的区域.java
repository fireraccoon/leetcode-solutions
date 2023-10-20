/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O' && board[1][i] == 'O') {
                dfs(board, 1, i);
            }
            if (board[m - 1][i] == 'O' && board[m - 2][i] == 'O') {
                dfs(board, m - 2, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O' && board[i][1] == 'O') {
                dfs(board, i, 1);
            }
            if (board[i][n - 1] == 'O' && board[i][n - 2] == 'O') {
                dfs(board, i, n - 2);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        board[i][j] = 'Y';
        if (i > 1 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (i < m - 2 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (j < n - 2 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }
}
// @lc code=end

