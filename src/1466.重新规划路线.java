/*
 * @lc app=leetcode.cn id=1466 lang=java
 *
 * [1466] 重新规划路线
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// @lc code=start
class Solution {
    @SuppressWarnings("unchecked")
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.length; i++) {
            graph[connections[i][0]].add(connections[i][1]);
            graph[connections[i][1]].add(-connections[i][0]);
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            ans += dfs(graph, queue, visited, queue.poll()) - 1;
        }
        return ans;
    }
    int dfs(List<Integer>[] graph, Queue<Integer> queue, boolean[] visited, int node) {
        int count = 1;
        visited[node] = true;
        for (int next : graph[node]) {
            if (next > 0) {
                if (!visited[next]) {
                    count += dfs(graph, queue, visited, next);
                }
            } else if (!visited[-next]) {
                queue.offer(-next);
            }
        }
        return count;
    }
}
// @lc code=end

