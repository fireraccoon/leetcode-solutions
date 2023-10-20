/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (stack.peek() > -1 && heights[i] < heights[stack.peek()]) {
                ans = Math.max(ans, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() > -1 && heights[stack.peek()] > 0) {
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return ans;
    }
}
// @lc code=end

