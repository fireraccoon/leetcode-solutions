/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    private enum VertexStatus {
        ORIGIN, VISITED, ADDED;
        public static VertexStatus[] defaultArray(int n) {
            VertexStatus[] vertexStatus = new VertexStatus[n];
            Arrays.fill(vertexStatus, ORIGIN);
            return vertexStatus;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return isDAG(graph);
    }
    boolean isDAG(List<List<Integer>> graph) {
        int n = graph.size();
        VertexStatus[] vertexStatus = VertexStatus.defaultArray(n);
        for (int i = 0; i < n; i++) {
            if (vertexStatus[i] == VertexStatus.ORIGIN && !dfs(graph, vertexStatus, i)) {
                return false;
            }
        }
        return true;
    }
    boolean dfs(List<List<Integer>> graph, VertexStatus[] vertexStatus, int vertex) {
        vertexStatus[vertex] = VertexStatus.VISITED;
        for (int i : graph.get(vertex)) {
            if (vertexStatus[i] == VertexStatus.VISITED
                || vertexStatus[i] == VertexStatus.ORIGIN && !dfs(graph, vertexStatus, i)) {
                return false;
            }
        }
        vertexStatus[vertex] = VertexStatus.ADDED;
        return true;
    }
}
// @lc code=end

