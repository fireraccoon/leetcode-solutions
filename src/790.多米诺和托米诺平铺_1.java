/*
 * @lc app=leetcode.cn id=790 lang=java
 *
 * [790] 多米诺和托米诺平铺
 */

// @lc code=start
class Solution {
    private final static int MOD = 1_000_000_007;
    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[3];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            long tmp = (dp[2] * 2 % MOD + dp[0]) % MOD;
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = (int) tmp;
        }
        return dp[2];
    }
}
// @lc code=end

