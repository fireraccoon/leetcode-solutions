/*
 * @lc app=leetcode.cn id=2352 lang=java
 *
 * [2352] 相等行列对
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> key = rowToList(grid, i);
            frequencies.put(key, frequencies.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += frequencies.getOrDefault(colToList(grid, i), 0);
        }
        return ans;
    }
    List<Integer> rowToList(int[][] grid, int row) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            list.add(grid[row][i]);
        }
        return list;
    }
    List<Integer> colToList(int[][] grid, int col) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            list.add(grid[i][col]);
        }
        return list;
    }
}
// @lc code=end

