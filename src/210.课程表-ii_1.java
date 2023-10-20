/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    private enum VertexStatus {
        ORIGIN, VISITED, ADDED;
        public static VertexStatus[] defaultArray(int n) {
            VertexStatus[] vertexStatus = new VertexStatus[n];
            Arrays.fill(vertexStatus, VertexStatus.ORIGIN);
            return vertexStatus;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return topologicalSort(graph);
    }
    int[] topologicalSort(List<List<Integer>> graph) {
        int n = graph.size();
        int[] ans = new int[n];
        VertexStatus[] vertexStatus = VertexStatus.defaultArray(n);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (vertexStatus[i] == VertexStatus.ORIGIN && !dfs(stack, graph, vertexStatus, i)) {
                return new int[0];
            }
        }
        for (int i = 0; !stack.isEmpty(); i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
    boolean dfs(Deque<Integer> stack, List<List<Integer>> graph, VertexStatus[] vertexStatus, int vertex) {
        vertexStatus[vertex] = VertexStatus.VISITED;
        for (int i : graph.get(vertex)) {
            if (vertexStatus[i] == VertexStatus.VISITED
                || vertexStatus[i] == VertexStatus.ORIGIN && !dfs(stack, graph, vertexStatus, i)) {
                return false;
            }
        }
        stack.push(vertex);
        vertexStatus[vertex] = VertexStatus.ADDED;
        return true;
    }
}
// @lc code=end

