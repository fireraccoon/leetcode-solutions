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
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            degrees[edges[i][0]]++;
            degrees[edges[i][1]]++;
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        return topoSortRoot(graph, degrees);
    }
    List<Integer> topoSortRoot(List<Integer>[] graph, int[] degrees) {
        int n = graph.length;
        if (n == 1) {
            return List.of(0);
        }

        Queue<Integer> queue = new LinkedList<>();
        int numToAdd = n;

        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.offer(i);
                degrees[i] = 0;
            }
        }

        while (numToAdd > 2) {
            int size = queue.size();
            numToAdd -= size;
            for (int i = 0; i < size; i++) {
                for (int j : graph[queue.poll()]) {
                    if (--degrees[j] == 1) {
                        queue.offer(j);
                        degrees[j] = 0;
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
// @lc code=end

