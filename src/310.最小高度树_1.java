/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int x = dfs(graph, parents, 0);
        int y = dfs(graph, parents, x);

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
    int dfs(List<Integer>[] graph, int[] parents, int root) {
        int n = graph.length;
        int[] distancesToRoot = new int[n];

        parents[root] = -1;
        Arrays.fill(distancesToRoot, -1);
        distancesToRoot[root] = 0;
        dfs(graph, parents, distancesToRoot, root);

        int ans = -1, maxDepth = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (distancesToRoot[i] > maxDepth) {
                ans = i;
                maxDepth = distancesToRoot[i];
            }
        }
        return ans;
    }
    void dfs(List<Integer>[] graph, int[] parents, int[] distancesToRoot, int root) {
        for (int node : graph[root]) {
            if (distancesToRoot[node] == -1) {
                distancesToRoot[node] = distancesToRoot[root] + 1;
                parents[node] = root;
                dfs(graph, parents, distancesToRoot, node);
            }
        }
    }
}
// @lc code=end

