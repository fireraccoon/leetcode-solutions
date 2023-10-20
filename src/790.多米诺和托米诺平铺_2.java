/*
 * @lc app=leetcode.cn id=790 lang=java
 *
 * [790] 多米诺和托米诺平铺
 */

// @lc code=start
class Solution {
    private final static long MOD = 1_000_000_007L;
    public int numTilings(int n) {
        long[] dp = new long[Math.max(3, n + 1)];
        dp[0] = dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            for (int j = i - 3; j >= 0; j--) {
                dp[i] = ((dp[i] + dp[j]) % MOD + dp[j]) % MOD;
            }
        }
        return (int) dp[n];
    }
}
// @lc code=end

