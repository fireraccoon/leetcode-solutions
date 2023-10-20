/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int dp_0 = 0, dp_1 = 1;
        while (--n > 0) {
            dp_1 += dp_0;
            dp_0 = dp_1 - dp_0;
        }
        return dp_1;
    }
}
// @lc code=end

