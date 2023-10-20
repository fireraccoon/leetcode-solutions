/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if (i >= k - 1) {
                ans[i - k + 1] = deque.peekFirst();
                if (deque.peekFirst() == nums[i - k + 1]) {
                    deque.pollFirst();
                }
            }
        }
        return ans;
    }
}
// @lc code=end

