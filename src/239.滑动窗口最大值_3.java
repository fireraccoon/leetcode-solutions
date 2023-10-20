/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<QueueNode> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new QueueNode(i, nums[i]));
            if (i >= k - 1) {
                while (queue.peek().index <= i - k) {
                    queue.poll();
                }
                ans[i - k + 1] = queue.peek().value;
            }
        }
        return ans;
    }
    private class QueueNode implements Comparable<QueueNode> {
        public int value;
        public int index;
        public QueueNode(int index, int value) {
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(QueueNode q) {
            return q.value - value;
        }
    }
}
// @lc code=end

