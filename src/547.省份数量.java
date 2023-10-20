/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.unite(i, j);
                }
            }
        }
        return uf.getNumOfSets();
    }

    private class UnionFind {

        private int numSets;

        private int[] sets;

        public UnionFind(int n) {
            numSets = n;
            sets = new int[n];
            for (int i = 0; i < n; i++) {
                sets[i] = i;
            }
        }

        public void unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                numSets--;
                sets[x] = y;
            }
        }

        public int find(int id) {
            if (id != sets[id]) {
                sets[id] = find(sets[id]);
            }
            return sets[id];
        }

        public int getNumOfSets() {
            return numSets;
        }
    }
}
// @lc code=end

