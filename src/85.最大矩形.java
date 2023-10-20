/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            ans = Math.max(ans, longestRectangleArea(heights));
        }
        return ans;
    }
    int longestRectangleArea(int[] heights) {
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

