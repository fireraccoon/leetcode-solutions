/*
 * @lc app=leetcode.cn id=909 lang=java
 *
 * [909] 蛇梯棋
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board[0].length, end = n * n;
        boolean[] visited = new boolean[end + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        for (int step = 1; !queue.isEmpty(); step++) {
            for (int i = queue.size(); i > 0; i--) {
                int node = queue.poll();
                int bound = Math.min(node + 6, end);
                for (int next = node + 1; next <= bound; next++) {
                    int row = getRow(next, n), col = getCol(next, n);
                    int jump = next;
                    if (board[row][col] != -1) {
                        jump = board[row][col];
                    }
                    if (jump == end) {
                        return step;
                    }
                    row = getRow(jump, n);
                    col = getCol(jump, n);
                    if (!visited[jump]) {
                        queue.offer(jump);
                        visited[jump] = true;
                    }
                }
            }
        }
        return -1;
    }
    int getRow(int index, int n) {
        return n - 1 - (index - 1) / n;
    }
    int getCol(int index, int n) {
        --index;
        return index / n % 2 == 0 ? index % n : n - 1 - index % n;
    }
}
// @lc code=end

