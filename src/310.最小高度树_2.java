/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// @lc code=start
class Solution {
    @SuppressWarnings("unchecked")
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        int[] parents = new int[n];
        int x = bfs(graph, parents, 0);
        int y = bfs(graph, parents, x);

        List<Integer> path = new ArrayList<>();
        do {
            path.add(y);
            y = parents[y];
        } while (y != -1);

        List<Integer> ans = new ArrayList<>();
        ans.add(path.get(path.size() >> 1));
        if (path.size() % 2 == 0) {
            ans.add(path.get(path.size() - 1 >> 1));
        }
        return ans;
    }
    int bfs(List<Integer>[] graph, int[] parents, int root) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        int lastNode = -1;
        queue.offer(root);
        parents[root] = lastNode;
        visited[root] = true;
        while (!queue.isEmpty()) {
            lastNode = queue.poll();
            for (int i : graph[lastNode]) {
                if (!visited[i]) {
                    queue.offer(i);
                    parents[i] = lastNode;
                    visited[i] = true;
                }
            }
        }
        return lastNode;
    }
}
// @lc code=end

