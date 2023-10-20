/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;

        Map<String, Integer> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.putIfAbsent(equations.get(i).get(0), nodes.size());
            nodes.putIfAbsent(equations.get(i).get(1), nodes.size());
        }

        double[][] graph = new double[nodes.size()][nodes.size()];
        for (int i = 0; i < n; i++) {
            int a = nodes.get(equations.get(i).get(0));
            int b = nodes.get(equations.get(i).get(1));
            graph[a][b] = values[i];
            graph[b][a] = 1D / values[i];
        }

        return Floyd(graph, queries, nodes);
    }
    double[] Floyd(double[][] graph, List<List<String>> queries, Map<String, Integer> nodes) {
        int n = queries.size();
        double[] ans = new double[n];
        double[][] f = new double[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                f[i][j] = graph[i][j] == 0 ? -1D : graph[i][j];
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if (f[j][i] == 0 || f[i][k] == 0) {
                        continue;
                    }
                    if (f[j][k] == -1 && f[j][i] != -1 && f[i][k] != -1) {
                        f[j][k] = f[j][i] * f[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Integer c = nodes.get(queries.get(i).get(0));
            Integer d = nodes.get(queries.get(i).get(1));
            ans[i] = c != null && d != null ? f[c][d] : -1D;
        }
        return ans;
    }
}
// @lc code=end

