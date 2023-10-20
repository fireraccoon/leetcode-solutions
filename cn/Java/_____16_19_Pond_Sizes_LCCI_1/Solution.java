// @algorithm @lc id=1000005 lang=java 
// @title pond-sizes-lcci
package _____16_19_Pond_Sizes_LCCI_1;
// @test([[0,2,1,0],[0,1,0,1],[1,1,0,1],[0,1,0,1]])=[1,2,4]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int[][] directions = new int[][] {
        { -1, -1 }, { 0, -1 }, { 1, -1 },
        { -1, 0 }, { 0, 1 },
        { -1, 1 }, { 1, 0 }, { 1, 1 }
    };
    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    ans.add(dfs(land, i, j));
                }
            }
        }
        return sortAndMapToInt(ans);
    }
    private int dfs(int[][] land, int x, int y) {
        int count = 1;
        int m = land.length, n = land[0].length;
        land[x][y] = -1;
        for (int i = 0; i < directions.length; i++) {
            int nx = x + directions[i][0], ny = y + directions[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && land[nx][ny] == 0) {
                count += dfs(land, nx, ny);
            }
        }
        return count;
    }
    private int[] sortAndMapToInt(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        Arrays.sort(array);
        return array;
    }
}