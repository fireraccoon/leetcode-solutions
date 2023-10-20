/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        } else if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return dividend;
            }
        }
        boolean signal = true;
        if (dividend > 0) {
            dividend = -dividend;
            signal = !signal;
        }
        if (divisor > 0) {
            divisor = -divisor;
            signal = !signal;
        }
        if (dividend > divisor) {
            return 0;
        }
        int ans = 1;
        int left = 1, right = Integer.MAX_VALUE, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (quickMultiply(divisor, mid, dividend)) {
                ans = mid;
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return signal ? ans : -ans;
    }
    /**
     * @return x * y >= min, x < 0, min < 0
     */
    boolean quickMultiply(int x, int y, int min) {
        while (true) {
            if ((y & 1) == 1) {
                min -= x;
                y--;
            } else {
                min -= min >> 1;
                y >>= 1;
            }
            if (min > 0) {
                return false;
            } else if (y == 0) {
                return true;
            }
        }
    }
}
// @lc code=end

