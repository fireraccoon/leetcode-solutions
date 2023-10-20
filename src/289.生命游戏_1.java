/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int prev = 0, curr = 0, next;
        for (int i = 0; i < n; i++) {
            curr |= board[0][i] << i + 1;
        }
        for (int i = 1; i < m; i++) {
            next = board[i][0] << 1;
            for (int j = 1; j < n; j++) {
                next |= board[i][j] << j + 1;
                board[i - 1][j - 1] = resultOfGame(prev, curr, next, j - 1);
            }
            board[i - 1][n - 1] = resultOfGame(prev, curr, next, n - 1);
            prev = curr;
            curr = next;
        }
        next = 0;
        for (int i = 0; i < n; i++) {
            board[m - 1][i] = resultOfGame(prev, curr, next, i);
        }
    }
    int resultOfGame(int prev, int curr, int next, int j) {
        int aliveCount = (prev >>> j & 1) + (prev >>> j + 1 & 1) + (prev >>> j + 2 & 1);
        aliveCount += (next >>> j & 1) + (next >>> j + 1 & 1) + (next >>> j + 2 & 1);
        aliveCount += (curr >> j & 1) + (curr >> j + 2 & 1);
        return aliveCount == 3
            || (curr >>> j + 1 & 1) == 1 && aliveCount >= 2 && aliveCount <= 3 ? 1 : 0;
    }
}
// @lc code=end

