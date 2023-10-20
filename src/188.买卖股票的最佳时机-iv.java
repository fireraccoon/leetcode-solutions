/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] buys = new int[k];
        int[] sells = new int[k];
        for (int i = 0; i < k; i++) {
            buys[i] = -prices[0];
            // sells[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = k - 1; j > 0; j--) {
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
                buys[j] = Math.max(buys[j], sells[j - 1] - prices[i]);
            }
            sells[0] = Math.max(sells[0], buys[0] + prices[i]);
            buys[0] = Math.max(buys[0], -prices[i]);
        }
        return Arrays.stream(sells).max().getAsInt();
    }
}
// @lc code=end

