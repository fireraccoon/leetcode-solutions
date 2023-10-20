/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// @lc code=start
class Solution {
    @SuppressWarnings("unchecked")
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length, m = queries.size();

        Map<String, Integer> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.putIfAbsent(equations.get(i).get(0), nodes.size());
            nodes.putIfAbsent(equations.get(i).get(1), nodes.size());
        }

        List<ValueWithIndex>[] graph = new List[nodes.size()];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int a = nodes.get(equations.get(i).get(0));
            int b = nodes.get(equations.get(i).get(1));
            graph[a].add(new ValueWithIndex(b, values[i]));
            graph[b].add(new ValueWithIndex(a, 1 / values[i]));
        }

        double[] ans = new double[m];
        for (int i = 0; i < m; i++) {
            Integer c = nodes.get(queries.get(i).get(0));
            Integer d = nodes.get(queries.get(i).get(1));
            ans[i] = c != null && d != null ? bfs(graph, values, c, d) : -1;
        }
        return ans;
    }
    double bfs(List<ValueWithIndex>[] graph, double[] values, int c, int d) {
        double[] ans = new double[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(ans, -1);
        ans[c] = 1;
        queue.offer(c);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == d) {
                break;
            }
            for (ValueWithIndex vi : graph[node]) {
                if (ans[vi.index] == -1) {
                    ans[vi.index] = ans[node] * vi.val;
                    queue.offer(vi.index);
                }
            }
        }
        return ans[d];
    }
    private class ValueWithIndex {
        public int index;
        public double val;
        public ValueWithIndex(int index, double val) {
            this.index = index;
            this.val = val;
        }
    }
}
// @lc code=end
