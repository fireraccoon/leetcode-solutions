/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new int[n], 0, 0, 0, 0);
        return ans;
    }
    void dfs(List<List<String>> ans, int[] node, int columns, int diagsLT, int diagsRT, int deepth) {
        int n = node.length;
        if (deepth >= n) {
            List<String> chess = new ArrayList<>();
            char[] s = new char[n];
            Arrays.fill(s, '.');
            for (int i = 0; i < n; i++) {
                s[node[i]] = 'Q';
                chess.add(new String(s));
                s[node[i]]  = '.';
            }
            ans.add(chess);
            return;
        }
        int columnsStore = columns;
        while (true) {
            int column = ~(columnsStore | diagsLT | diagsRT) & ((1 << n) - 1);
            if (column == 0) {
                break;
            }
            column &= -column;
            columnsStore |= column;
            node[deepth] = Integer.bitCount(column - 1);
            dfs(ans, node, columns | column, (diagsLT | column) << 1, (diagsRT | column) >> 1, deepth + 1);
        }
    }
}
// @lc code=end

