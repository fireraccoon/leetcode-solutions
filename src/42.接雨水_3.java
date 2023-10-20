/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                ans += (i - left - 1) * (Math.min(height[left], height[i]) - height[top]);
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

