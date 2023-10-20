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
        int n = values.length, m = queries.size();

        Map<String, Integer> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.putIfAbsent(equations.get(i).get(0), nodes.size());
            nodes.putIfAbsent(equations.get(i).get(1), nodes.size());
        }

        UnionFind uf = new UnionFind(nodes.size());
        for (int i = 0; i < n; i++) {
            int a = nodes.get(equations.get(i).get(0));
            int b = nodes.get(equations.get(i).get(1));
            uf.uinte(a, b, values[i]);
        }

        double[] ans = new double[m];
        for (int i = 0; i < m; i++) {
            Integer c = nodes.get(queries.get(i).get(0));
            Integer d = nodes.get(queries.get(i).get(1));
            if (c != null && d != null && uf.find(c) == uf.find(d)) {
                ans[i] = uf.getWeight(c) / uf.getWeight(d);
            } else {
                ans[i] = -1D;
            }
        }
        return ans;
    }

    private class UnionFind {

        private int[] sets;

        private double[] weights;

        public UnionFind(int n) {
            sets = new int[n];
            weights = new double[n];
            for (int i = 0; i < n; i++) {
                sets[i] = i;
                weights[i] = 1D;
            }
        }

        public void uinte(int x, int y, double weight) {
            int idx = find(x);
            int idy = find(y);
            if (idx != idy) {
                sets[idx] = idy;
                weights[idx] = weight * weights[y] / weights[x];
            }
        }

        public int find(int x) {
            if (sets[x] != x) {
                int parent = find(sets[x]);
                weights[x] *= weights[sets[x]];
                sets[x] = parent;
            }
            return sets[x];
        }

        public double getWeight(int x) {
            return weights[x];
        }
    }
}
// @lc code=end

