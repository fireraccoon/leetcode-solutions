/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

import java.util.Comparator;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int ans = 0;
        int m = dungeon.length, n = dungeon[0].length;
        PriorityQueue<QueueNode> queue = new PriorityQueue<>(new Comparator<QueueNode>() {
            @Override
            public int compare(QueueNode n1, QueueNode n2) {
                return n2.minimumHP - n1.minimumHP;
            }
        });
        queue.offer(new QueueNode(dungeon, 0, 0, 0, 0));
        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            if (node.x == m - 1 && node.y == n - 1) {
                ans = -node.minimumHP + 1;
                break;
            }
            if (node.x + 1 < m) {
                queue.offer(new QueueNode(dungeon, node.x + 1, node.y, node.pathValue, node.minimumHP));
            }
            if (node.y + 1 < n) {
                queue.offer(new QueueNode(dungeon, node.x, node.y + 1, node.pathValue, node.minimumHP));
            }
        }
        return ans;
    }
    private class QueueNode {
        public int x, y;
        public int pathValue, minimumHP;
        public QueueNode (int[][] dungeon, int x, int y, int lastPathValue, int lastMinimumHP) {
            this.x = x;
            this.y = y;
            this.pathValue = lastPathValue + dungeon[x][y];
            this.minimumHP = Math.min(this.pathValue, lastMinimumHP);
        }
    }
}
// @lc code=end

