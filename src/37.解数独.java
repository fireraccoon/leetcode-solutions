/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

import java.util.List;
import java.util.ArrayList;

// @lc code=start

class Solution {

    private int[] lines = new int[9];
    private int[] columns = new int[9];
    private int[][] blocks = new int[9][9];
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    flip(i, j, board[i][j] - '1');
                }
            }
        }

        while (true) {
            boolean isModified = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0;  j < 9; j++) {
                    if (board[i][j] == '.') {
                        /** check if only the one bit as 0 */
                        int mask = ~(lines[i] | columns[j] | blocks[i/3][j/3]) & 0b111111111;
                        if (Integer.bitCount(mask) == 1) {
                            int num = Integer.bitCount(mask - 1);
                            flip(i, j, num);
                            board[i][j] = (char)(num + '1');
                            isModified = true;
                        }
                    }
                }
            }
            if (!isModified) {
                break;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0;  j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[] {i, j});
                }
            }
        }

        dfs(board, 1);
    }

    boolean dfs(char[][] board, int deepth) {
        if (deepth > spaces.size()) {
            return true;
        }
        int[] space = spaces.get(deepth - 1);
        int i = space[0], j = space[1];
        /** try all zeros position */
        int mask = ~(lines[i] | columns[j] | blocks[i/3][j/3]) & 0b111111111;
        while (Integer.bitCount(mask) != 0) {
            int num = Integer.bitCount((mask & -mask) - 1);
            flip(i, j, num);
            if (dfs(board, deepth + 1)) {
                board[i][j] = (char)(num + '1');
                return true;
            }
            flip(i, j, num);
            mask ^= (1 << num);
        }
        return false;
    }

    /**
     * flip the value of num
     */
    void flip(int i, int j, int num) {
        lines[i] ^= (1 << num);
        columns[j] ^= (1 << num);
        blocks[i/3][j/3] ^= (1 << num);
    }
}
// @lc code=end

