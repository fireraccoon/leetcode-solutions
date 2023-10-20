/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isInteger(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                stack.push(compute(stack.pop(), stack.pop(), tokens[i]));
            }
        }
        return stack.pop();
    }
    boolean isInteger(String s) {
        return Character.isDigit(s.charAt(s.length() - 1));
    }
    int compute(int b, int a, String option) {
        return switch (option) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
// @lc code=end

