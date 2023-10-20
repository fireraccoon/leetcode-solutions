// @algorithm @lc id=1000011 lang=java 
// @title robot-in-a-grid-lcci
package _____08_02_Robot_in_a_Grid_LCCI;
// @test([[0,0,0],[0,1,0],[0,0,0]])=[[0,0],[0,1],[0,2],[1,2],[2,2]]
// @test([[1]])=[]
// @test([[0,1]])=[]
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = obstacleGrid[i - 1][0] == 0
                && obstacleGrid[i][0] == 0 ? 0 : 1;
        }
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i - 1] == 0
                && obstacleGrid[0][i] == 0 ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = (obstacleGrid[i][j - 1] == 0
                    || obstacleGrid[i - 1][j] == 0)
                    && obstacleGrid[i][j] == 0 ? 0 : 1;
            }
        }

        int x = m - 1, y = n - 1;
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (obstacleGrid[x][y] == 1) {
            return ans;
        }
        while (x > 0 || y > 0) {
            ans.addFirst(List.of(x, y));
            if (x > 0 && obstacleGrid[x - 1][y] == 0) {
                x--;
            } else {
                y--;
            }
        }
        ans.addFirst(List.of(0, 0));
        return ans;
    }
}