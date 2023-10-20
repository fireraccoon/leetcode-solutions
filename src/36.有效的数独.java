/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows[i][board[i][j]-'1'] != 0) {
                    return false;
                } else {
                    rows[i][board[i][j]-'1'] = 1;
                }
                if (cols[j][board[i][j]-'1'] != 0) {
                    return false;
                } else {
                    cols[j][board[i][j]-'1'] = 1;
                }
                if (boxes[i/3][j/3][board[i][j]-'1'] != 0) {
                    return false;
                } else {
                    boxes[i/3][j/3][board[i][j]-'1'] = 1;
                }
            }
        }
        return true;
    }
}
// @lc code=end

