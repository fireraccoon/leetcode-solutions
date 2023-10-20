/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        Deque<Window> queue = new LinkedList<>();
        int prefixSum = nums[0], ans = nums[0];
        queue.offerLast(new Window(0, prefixSum));
        for (int right = 1; right < n * 2; right++) {
            if (!queue.isEmpty() && right - queue.peekFirst().left > n) {
                queue.pollFirst();
            }
            prefixSum += nums[right % n];
            ans = Math.max(ans, prefixSum - queue.peekFirst().prefixSum);
            while (!queue.isEmpty() && queue.peekLast().prefixSum >= prefixSum) {
                queue.pollLast();
            }
            queue.offerLast(new Window(right, prefixSum));
        }
        return ans;
    }
    private class Window {
        public int left;
        public int prefixSum;
        public Window(int left, int prefixSum) {
            this.left = left;
            this.prefixSum = prefixSum;
        }
    }
}
// @lc code=end

