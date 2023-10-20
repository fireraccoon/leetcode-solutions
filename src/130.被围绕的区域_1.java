/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O' && board[1][i] == 'O') {
                bfs(board, 1, i);
            }
            if (board[m - 1][i] == 'O' && board[m - 2][i] == 'O') {
                bfs(board, m - 2, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O' && board[i][1] == 'O') {
                bfs(board, i, 1);
            }
            if (board[i][n - 1] == 'O' && board[i][n - 2] == 'O') {
                bfs(board, i, n - 2);
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
    void bfs(char[][] board, int i, int j) {
        Queue<Integer> queueRow = new LinkedList<>();
        Queue<Integer> queueCol = new LinkedList<>();
        int m = board.length, n = board[0].length;
        queueRow.offer(i);
        queueCol.offer(j);
        while (!queueRow.isEmpty()) {
            for (int l = queueCol.size() - 1; l >= 0; l--) {
                i = queueRow.poll();
                j = queueCol.poll();
                if (board[i][j] == 'Y') {
                    continue;
                }
                board[i][j] = 'Y';
                if (i > 1 && board[i - 1][j] == 'O') {
                    queueRow.offer(i - 1);
                    queueCol.offer(j);
                }
                if (i < m - 2 && board[i + 1][j] == 'O') {
                    queueRow.offer(i + 1);
                    queueCol.offer(j);
                }
                if (j > 1 && board[i][j - 1] == 'O') {
                    queueRow.offer(i);
                    queueCol.offer(j - 1);
                }
                if (j < n - 2 && board[i][j + 1] == 'O') {
                    queueRow.offer(i);
                    queueCol.offer(j + 1);
                }
            }
        }
    }
}
// @lc code=end

