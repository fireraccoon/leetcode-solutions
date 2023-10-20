// @algorithm @lc id=1000011 lang=java 
// @title robot-in-a-grid-lcci
package _____08_02_Robot_in_a_Grid_LCCI_2;
// @test([[0,0,0],[0,1,0],[0,0,0]])=[[0,0],[0,1],[0,2],[1,2],[2,2]]
// @test([[1]])=[]
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        Queue<List<List<Integer>>> space = new LinkedList<>();
        if (obstacleGrid[0][0] == 0) {
            queue.offer(0);
            space.offer(List.of(List.of(0, 0)));
        }
        while (!queue.isEmpty()) {
            int x = queue.poll(), y = x & 0x0000ffff;
            x >>>= 16;
            List<List<Integer>> node = space.poll();
            if (x == m - 1 && y == n - 1) {
                return node;
            }
            if (y + 1 < n && obstacleGrid[x][y + 1] == 0) {
                List<List<Integer>> next = new LinkedList<>(node);
                next.add(List.of(x, y + 1));
                queue.offer(x << 16 | y + 1);
                space.offer(next);
                obstacleGrid[x][y + 1] = 1;
            }
            if (x + 1 < m && obstacleGrid[x + 1][y] == 0) {
                List<List<Integer>> next = new LinkedList<>(node);
                next.add(List.of(x + 1, y));
                queue.offer(x + 1 << 16 | y);
                space.offer(next);
                obstacleGrid[x + 1][y] = 1;
            }
        }
        return List.of();
    }
}