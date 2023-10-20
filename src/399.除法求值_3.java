/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] ans = new double[n];
        Set<String> charset = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            charset.add(equations.get(i).get(0));
            charset.add(equations.get(i).get(1));
        }
        boolean[] visited = new boolean[values.length];
        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            String c = query.get(0);
            String d = query.get(1);
            if (!charset.contains(c) || !charset.contains(d)) {
                ans[i] = -1;
            } else if (c.equals(d)) {
                ans[i] = 1;
            } else {
                ans[i] = dfs(equations, values, visited, c, d, 1D);
            }
        }
        return ans;
    }
    double dfs(List<List<String>> equations, double[] values, boolean[] visited, String c, String d, double result) {
        int n = equations.size();
        double ans = -1;
        for (int i = 0; i < n && ans == -1; i++) {
            if (visited[i]) {
                continue;
            }
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (a.equals(d) && b.equals(c)) {
                return result / values[i];
            } else if (a.equals(c) && b.equals(d)) {
                return result * values[i];
            }
            visited[i] = true;
            if (a.equals(c)) {
                ans = dfs(equations, values, visited, b, d, result * values[i]);
            } else if (a.equals(d)) {
                ans = dfs(equations, values, visited, c, b, result / values[i]);
            } else if (b.equals(c)) {
                ans = dfs(equations, values, visited, a, d, result / values[i]);
            } else if (b.equals(d)) {
                ans = dfs(equations, values, visited, c, a, result * values[i]);
            }
            visited[i] = false;
        }
        return ans;
    }
}
// @lc code=end
