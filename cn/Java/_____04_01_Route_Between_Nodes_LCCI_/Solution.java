// @algorithm @lc id=100171 lang=java 
// @title route-between-nodes-lcci
package _____04_01_Route_Between_Nodes_LCCI_;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// @test(3,[[0,1],[0,2],[1,2],[1,2]],0,2)=true
public class Solution {
    @SuppressWarnings("unchecked")
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }

        List<Integer>[] graphForVertexes = new List[n];
        for (int i = 0; i < n; i++) {
            graphForVertexes[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            graphForVertexes[graph[i][0]].add(graph[i][1]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graphForVertexes[node]) {
                if (!visited[next]) {
                    if (next == target) {
                        return true;
                    }
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }
}