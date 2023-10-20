/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (x == 0.) {
            return 0.;
        } else if (n == 0) {
            return 1.;
        }
        double p = 1.;
        if (n == Integer.MIN_VALUE) {
            n++;
            p = x;
        }
        return n > 0 ? quickPow(x, n) : 1 / (quickPow(x, -n) * p);
    }
    double quickPow(double x, int n) {
        if (n == 0) {
            return 1.;
        }
        double ans = quickPow(x, n >> 1);
        ans *= ans;
        if ((n & 0b1) == 1) {
            ans *= x;
        }
        return ans;
    }
}
// @lc code=end

