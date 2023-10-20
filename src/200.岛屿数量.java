/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length,n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.unite((i - 1) * n + j, i * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.unite(i * n + j - 1, i * n + j);
                    }
                }
            }
        }
        return uf.getNumSets();
    }

    private class UnionFind {

        private static final int RIVER_SET_ID = -1;

        private int numSets = 0;

        private int[] sets;

        public UnionFind(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            sets = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int index = i * n + j;
                    if (grid[i][j] == '0') {
                        sets[index] = RIVER_SET_ID;
                    } else {
                        sets[index] = index;
                        numSets++;
                    }
                }
            }
        }

        public void unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                sets[x] = y;
                numSets--;
            }
        }

        public int find(int x) {
            if (sets[x] != x && sets[x] != RIVER_SET_ID) {
                sets[x] = find(sets[x]);
            }
            return sets[x];
        }

        public int getNumSets() {
            return numSets;
        }
    }

}
// @lc code=end

