/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                ans++;
                bfs(isConnected, visited, i);
            }
        }
        return ans;
    }
    void bfs(int[][] graph, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int pointer = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i] && graph[pointer][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
// @lc code=end

