// @algorithm @lc id=1000005 lang=java 
// @title pond-sizes-lcci
package _____16_19_Pond_Sizes_LCCI;
// @test([[0,2,1,0],[0,1,0,1],[1,1,0,1],[0,1,0,1]])=[1,2,4]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        UnionFind uf = new UnionFind(m * n);
        int[][] directions = new int[][] {
            { 1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 1 }
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] != 0) {
                    continue;
                }
                for (int k = 0; k < directions.length; k++) {
                    int ii = i + directions[k][0], jj = j + directions[k][1];
                    if (ii >= 0 && ii < m && jj < n && land[ii][jj] == 0) {
                        uf.unite(i * n + j, ii * n + jj);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0 && uf.isRoot(i * n + j)) {
                    ans.add(uf.getCounts(i * n + j));
                }
            }
        }
        return sortAndMapToInt(ans);
    }

    private int[] sortAndMapToInt(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        Arrays.sort(array);
        return array;
    }

    private class UnionFind {

        private int[] sets, counts;

        public UnionFind(int size) {
            sets = new int[size];
            counts = new int[size];
            for (int i = 0; i < size; i++) {
                sets[i] = i;
                counts[i] = 1;
            }
        }

        public void unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                sets[x] = y;
                counts[y] += counts[x];
            }
        }

        public int find(int node) {
            if (node != sets[node]) {
                sets[node] = find(sets[node]);
            }
            return sets[node];
        }

        public boolean isRoot(int node) {
            return node == sets[node];
        }

        public int getCounts(int node) {
            return counts[node];
        }
    }
}