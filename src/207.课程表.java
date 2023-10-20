/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return isDAG(graph, indegrees);
    }
    boolean isDAG(List<List<Integer>> graph, int[] indegrees) {
        int n = graph.size();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            n--;
            for (int i : graph.get(queue.poll())) {
                if (--indegrees[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return n == 0;
    }
}
// @lc code=end

