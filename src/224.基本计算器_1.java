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
        Deque<Character> stackSignal = new LinkedList<>();
        int i = 0;
        char lastC = '(';
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            } else if (Character.isDigit(c)) {
                int number = Character.digit(c, 10);
                while (++i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + Character.digit(s.charAt(i), 10);
                }
                stack.push(number);
                if (!stackSignal.isEmpty() && stackSignal.peek() != '(') {
                    stack.push(compute(stack.pop(), stack.pop(), stackSignal.pop()));
                }
            } else if (c == ')') {
                stackSignal.pop();
                if (!stackSignal.isEmpty() && stackSignal.peek() != '(') {
                    stack.push(compute(stack.pop(), stack.pop(), stackSignal.pop()));
                }
                i++;
            } else {
                if (c == '-' && lastC == '(') {
                    stack.push(0);
                }
                stackSignal.push(c);
                i++;
            }
            lastC = c;
        }
        return stack.pop();
    }
    int compute(int y, int x, char signal) {
        return signal == '+' ? x + y : x - y;
    }
}
// @lc code=end

