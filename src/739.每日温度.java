/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperature) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

