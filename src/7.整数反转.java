/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int signal = x < 0 ? -1 : 1;
        x *= signal;
        int result = 0;
        while (true) {
            if (x == 0) {
                return result * signal;
            }
            if (Integer.MAX_VALUE / 10 - result < 0) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
    }
}
// @lc code=end

