/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                ans++;
                dfs(isConnected, visited, i);
            }
        }
        return ans;
    }
    void dfs(int[][] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(graph, visited, i);
            }
        }
    }
}
// @lc code=end

