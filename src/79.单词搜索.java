/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, String word, int i, int j, int length) {
        if (board[i][j] != word.charAt(length)) {
            return false;
        } else if (word.length() == length + 1) {
            return true;
        }
        board[i][j] |= 0x100;
        if ((i > 0 && (board[i - 1][j] & 0x100) == 0 && dfs(board, word, i - 1, j, length + 1))
            || (j > 0 && (board[i][j - 1] & 0x100) == 0 && dfs(board, word, i, j - 1, length + 1))
            || (i < board.length - 1 && (board[i + 1][j] & 0x100) == 0 && dfs(board, word, i + 1, j, length + 1))
            || (j < board[0].length - 1 && (board[i][j + 1] & 0x100) == 0 && dfs(board, word, i, j + 1, length + 1))) {
            return true;
        }
        board[i][j] ^= 0x100;
        return false;
    }
}
// @lc code=end

