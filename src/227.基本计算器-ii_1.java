/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        char lastOption = '+';
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (Character.isDigit(c)) {
                int number = Character.digit(c, 10);
                while (++i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + Character.digit(s.charAt(i), 10);
                }
                option(stack, number, lastOption);
            } else {
                lastOption = c;
                i++;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
    void option(Deque<Integer> stack, int number, char option) {
        switch (option) {
            case '+' : {
                stack.push(number);
                break;
            }
            case '-' : {
                stack.push(-number);
                break;
            }
            case '*' : {
                stack.push(stack.pop() * number);
                break;
            }
            case '/' : {
                stack.push(stack.pop() / number);
                break;
            }
        }
    }
}
// @lc code=end

