/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return topologicalSort(graph, indegrees);
    }
    int[] topologicalSort(List<List<Integer>> graph, int[] indegrees) {
        int n = graph.size();
        int added = 0;
        int[] ans = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            ans[added++] = vertex;
            for (int v : graph.get(vertex)) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return added < n ? new int[0] : ans;
    }
}
// @lc code=end

