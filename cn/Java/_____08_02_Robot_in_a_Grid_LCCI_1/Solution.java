// @algorithm @lc id=1000011 lang=java 
// @title robot-in-a-grid-lcci
package _____08_02_Robot_in_a_Grid_LCCI_1;
// @test([[0,0,0],[0,1,0],[0,0,0]])=[[0,0],[0,1],[0,2],[1,2],[2,2]]
// @test([[1]])=[]
import java.util.LinkedList;
import java.util.List;

public class Solution {
    int m, n;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (obstacleGrid[0][0] == 0) {
            dfs(ans, obstacleGrid, 0, 0);
        }
        return ans;
    }
    boolean dfs(LinkedList<List<Integer>> node, int[][] obstacleGrid, int x, int y) {
        node.add(List.of(x, y));
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        obstacleGrid[x][y] = 1;
        if (y + 1 < n && obstacleGrid[x][y + 1] == 0) {
            if (dfs(node, obstacleGrid, x, y + 1)) {
                return true;
            }
        }
        if (x + 1 < m && obstacleGrid[x + 1][y] == 0) {
            if (dfs(node, obstacleGrid, x + 1, y)) {
                return true;
            }
        }
        node.removeLast();
        return false;
    }
}