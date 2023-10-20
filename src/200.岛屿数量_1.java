/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
    void dfs(char[][] grid, int i, int j) {
        visited[i][j] = true;
        if (i > 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            dfs(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            dfs(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            dfs(grid, i + 1, j);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            dfs(grid, i, j + 1);
        }
    }
}
// @lc code=end

