/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int signal = 1;
        long result = 0;
        int i = 0;
        for(; i < s.length() && s.charAt(i) == ' '; i++);
        if (i == s.length()) {
            return 0;
        }
        if (s.charAt(i) == '-') {
            signal = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        for (; i < s.length(); i++) {
            if (isNum(s.charAt(i))) {
                result = result * 10 + ctoi(s.charAt(i)) * signal;
            } else {
                break;
            }
            if (result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)result;
    }
    boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }
    int ctoi(char c) {
        return c - '0';
    }
}
// @lc code=end

