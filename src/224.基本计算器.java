/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int sign = 1;
        int ans = 0;
        int i = 0;
        while (i < n) {
            int c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            } else if (Character.isDigit(c)) {
                int number = Character.digit(c, 10);
                while (++i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + Character.digit(s.charAt(i), 10);
                }
                ans += sign * number;
            } else if (c == '(') {
                stack.push(sign);
                i++;
            } else if (c == ')') {
                stack.pop();
                i++;
            } else {
                sign = c == '+' ? stack.peek() : -stack.peek();
                i++;
            }
        }
        return ans;
    }
}
// @lc code=end

