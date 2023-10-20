/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
        List<Integer> ans = new ArrayList<>();
        int minDeepth = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int deepth = bfs(graph, i, minDeepth);
            if (deepth < minDeepth) {
                ans.clear();
                minDeepth = deepth;
            }
            if (minDeepth == deepth) {
                ans.add(i);
            }
        }
        return ans;
    }
    int bfs(List<Integer>[] graph, int root, int minDeepth) {
        int deepth = 0;
        Set<Integer> added = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        added.add(root);
        while (!queue.isEmpty() && deepth < minDeepth) {
            for (int i = queue.size(); i > 0; i--) {
                for (Integer node : graph[queue.poll()]) {
                    if (added.add(node)) {
                        queue.offer(node);
                    }
                }
            }
            deepth++;
        }
        return queue.isEmpty() ? deepth : Integer.MAX_VALUE;
    }
}
// @lc code=end

