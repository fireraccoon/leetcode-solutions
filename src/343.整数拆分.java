/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int mod_3 = n % 3;
        if (mod_3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (mod_3 == 1) {
            return (int) Math.pow(3, n / 3 - 1) * 4;
        } else {
            return (int) Math.pow(3, n / 3) * 2;
        }
    }
}
// @lc code=end

