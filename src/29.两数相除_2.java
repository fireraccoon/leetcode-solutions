/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> facs = new ArrayList<>();
        for (int fac = divisor; ; fac <<= 1) {
            facs.add(fac);
            if (dividend - fac > fac) {
                break;
            }
        }
        int ans = 0;
        for (int i = facs.size() - 1; i >= 0; i--) {
            if (dividend <= facs.get(i)) {
                ans |= 1;
                dividend -= facs.get(i);
            }
            if (i != 0) {
                ans <<= 1;
            }
        }
        return signal ? ans : -ans;
    }
}
// @lc code=end

