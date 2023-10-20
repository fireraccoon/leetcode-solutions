/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int dp_0, dp_1, dp_now;
        dp_0 = isLegalNum('N', s.charAt(0)) ? 1 : 0;
        dp_1 = isLegalNum(s.charAt(0), s.charAt(1)) ? 1 : 0;
        dp_1 += isLegalNum('N', s.charAt(1)) ? dp_0 : 0;
        for (int i = 2; i < s.length(); i++) {
            dp_now = isLegalNum(s.charAt(i - 1), s.charAt(i)) ? dp_0 : 0;
            dp_now += isLegalNum('N', s.charAt(i)) ? dp_1 : 0;
            dp_0 = dp_1;
            dp_1 = dp_now;
        }
        return dp_1;
    }
    boolean isLegalNum(char a, char b) {
        if (a == '0') {
            return false;
        }
        int num;
        if (a == 'N') {
            num = b - '0';
        } else {
            num = (a - '0') * 10 + b - '0';
        }
        return num >= 1 && num <= 26;
    }
}
// @lc code=end

