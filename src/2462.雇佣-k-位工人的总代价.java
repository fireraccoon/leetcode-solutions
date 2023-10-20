/*
 * @lc app=leetcode.cn id=2462 lang=java
 *
 * [2462] 雇佣 K 位工人的总代价
 */

import java.util.Arrays;
import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0L;
        if (costs.length <= candidates * 2) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }

        int left = 0, right = costs.length - 1;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            leftHeap.offer(costs[left++]);
            rightHeap.offer(costs[right--]);
        }
        for (int i = 0; i < k; i++) {
            int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
            if (!leftHeap.isEmpty()) {
                x = leftHeap.peek();
            }
            if (!rightHeap.isEmpty()) {
                y = rightHeap.peek();
            }
            if (x <= y) {
                ans += x;
                leftHeap.poll();
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                ans += y;
                rightHeap.poll();
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

