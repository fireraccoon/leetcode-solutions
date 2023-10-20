/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    private final static int ALWAYS_DEAD = 0;
    private final static int ALWAYS_ALIVE = 1;
    private final static int DEAD_TO_ALIVE = -1;
    private final static int ALIVE_TO_DEAD = 2;
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = gameOfResult(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == DEAD_TO_ALIVE) {
                    board[i][j] = ALWAYS_ALIVE;
                } else if (board[i][j] == ALIVE_TO_DEAD) {
                    board[i][j] = ALWAYS_DEAD;
                }
            }
        }
    }
    int gameOfResult(int[][] board, int row, int col) {
        int aliveCount = -board[row][col];
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    aliveCount += board[i][j] <= ALWAYS_DEAD ? 0 : 1;
                }
            }
        }
        if (board[row][col] == ALWAYS_DEAD) {
            return aliveCount == 3 ? DEAD_TO_ALIVE : ALWAYS_DEAD;
        } else {
            return aliveCount >= 2 && aliveCount <= 3 ? ALWAYS_ALIVE : ALIVE_TO_DEAD;
        }
    }
}
// @lc code=end

