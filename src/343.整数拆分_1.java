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

        int dp_0 = 1, dp_1 = 1, dp_2 = 2;
        for (int i = 4; i <= n; i++) {
            int next = Math.max(2 * Math.max(i - 2, dp_1), 3 * Math.max(i - 3, dp_0));
            dp_0 = dp_1;
            dp_1 = dp_2;
            dp_2 = next;
        }
        return dp_2;
    }
}
// @lc code=end

