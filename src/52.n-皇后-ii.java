/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N 皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        return dfs(0, 0, 0, 0, n, 0);
    }
    int dfs(int ans, int columns, int diagsLT, int diagsRT, int n, int deepth) {
        if (deepth >= n) {
            return ans + 1;
        }
        int columnsStore = columns;
        while (true) {
            int column = ~(columnsStore | diagsLT | diagsRT) & ((1 << n) - 1);
            if (column == 0) {
                break;
            }
            column &= -column;
            columnsStore |= column;
            ans = dfs(ans, columns | column, (diagsLT | column) << 1, (diagsRT | column) >> 1, n, deepth + 1);
        }
        return ans;
    }
}
// @lc code=end

