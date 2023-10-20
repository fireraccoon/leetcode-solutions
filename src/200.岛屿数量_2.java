/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    void bfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(i << 16 | j);
        while (!queue.isEmpty()) {
            i = queue.poll();
            j = i & 0xffff;
            i >>>= 16;
            if (i > 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                queue.offer(i - 1 << 16 | j);
            }
            if (j > 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                queue.offer(i << 16 | j - 1);
            }
            if (i < m - 1 && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                queue.offer(i + 1 << 16 | j);
            }
            if (j < n - 1 && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                queue.offer(i << 16 | j + 1);
            }
        }
    }
}
// @lc code=end

