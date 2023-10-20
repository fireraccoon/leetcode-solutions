/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        for (int i = 1; i < n; i++) {
            long min = heap.poll();
            if (set.add(2 * min)) {
                heap.offer(2 * min);
            }
            if (set.add(3 * min)) {
                heap.offer(3 * min);
            }
            if (set.add(5 * min)) {
                heap.offer(5 * min);
            }
        }
        return heap.peek().intValue();
    }
}
// @lc code=end

