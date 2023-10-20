/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        for (int i = 1; i < n; i++) {
            long min = heap.poll();
            for (int j = 0; j < primes.length; j++) {
                long number = primes[j] * min;
                if (set.add(number)) {
                    heap.offer(number);
                }
            }
        }
        return heap.peek().intValue();
    }
}
// @lc code=end

