/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> freshes = new HashSet<>();
        Queue<Integer> rottens = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    freshes.add(row << 16 | col);
                } else if (grid[row][col] == 2) {
                    rottens.offer(row << 16 | col);
                }
            }
        }

        int ans;
        for (ans = 0; !freshes.isEmpty() && !rottens.isEmpty(); ans++) {
            for (int i = rottens.size(); i > 0; i--) {
                int row = rottens.poll(), col = row & 0xff, key;
                row >>>= 16;
                if (row > 0 && freshes.remove(key = row - 1 << 16 | col)) {
                    rottens.offer(key);
                }
                if (col > 0 && freshes.remove(key = row << 16 | col - 1)) {
                    rottens.offer(key);
                }
                if (row < m - 1 && freshes.remove(key = row + 1 << 16 | col)) {
                    rottens.offer(key);
                }
                if (col < n - 1 && freshes.remove(key = row << 16 | col + 1)) {
                    rottens.offer(key);
                }
            }
        }
        return freshes.isEmpty() ? ans : -1;
    }
}
// @lc code=end

