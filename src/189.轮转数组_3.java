/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        k %= n;
        for (int i = 0; i < n; i++) {
            queue.offer(nums[i]);
        }
        while (k-- > 0) {
            queue.offerFirst(queue.pollLast());
        }
        for (int i = 0; i < n; i++) {
            nums[i] = queue.poll();
        }
    }
}
// @lc code=end

