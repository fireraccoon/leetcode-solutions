/*
 * @lc app=leetcode.cn id=1926 lang=java
 *
 * [1926] 迷宫中离入口最近的出口
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<Integer> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        queue.offer(entrance[0] << 16 | entrance[1]);
        for (int step = 0; !queue.isEmpty(); step++) {
            for (int i = queue.size(); i > 0; i--) {
                int row = queue.poll(), col = row & 0xff;
                row >>>= 16;
                if (step > 0 && (row == 0 || row == m - 1 || col == 0 || col == n - 1)) {
                    return step;
                }
                if (row > 0 && maze[row - 1][col] == '.') {
                    queue.offer(row - 1 << 16 | col);
                    maze[row - 1][col] = '+';
                }
                if (col > 0 && maze[row][col - 1] == '.') {
                    queue.offer(row << 16 | col - 1);
                    maze[row][col - 1] = '+';
                }
                if (row < m - 1 && maze[row + 1][col] == '.') {
                    queue.offer(row + 1 << 16 | col);
                    maze[row + 1][col] = '+';
                }
                if (col < n - 1 && maze[row][col + 1] == '.') {
                    queue.offer(row << 16 | col + 1);
                    maze[row][col + 1] = '+';
                }
            }
        }
        return -1;
    }
}
// @lc code=end

