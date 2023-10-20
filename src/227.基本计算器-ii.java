/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int n = s.length();
        int ans = 0;
        int value = 0;
        char lastOption = '+';
        int sign = 1;
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (Character.isDigit(c)) {
                int number = Character.digit(c, 10);
                while (++i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + Character.digit(s.charAt(i), 10);
                }
                value = computeMulOrDiv(value, number, lastOption);
            } else {
                if (c == '+' || c == '-') {
                    ans += value * sign;
                    sign = c == '+' ? 1 : -1;
                }
                lastOption = c;
                i++;
            }
        }
        return ans + value * sign;
    }
    int computeMulOrDiv(int a, int b, char option) {
        if (option == '*') {
            return a * b;
        } else if (option == '/') {
            return a / b;
        } else {
            return b;
        }
    }
}
// @lc code=end

