/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k][2];
        for (int i = 0; i < k; i++) {
            dp[0][i][0] = -prices[0];
            // dp[0][i][1] = 0;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, dp[n - 1][i][1]);
        }
        return ans;
    }
}
// @lc code=end

