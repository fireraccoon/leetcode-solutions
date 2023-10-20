/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 买卖股票的最佳时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -prices[0], frozen = 0, sell = 0;
        for (int i = 1; i < n; i++) {
            int newSell = Math.max(sell, frozen);
            frozen = buy + prices[i];
            buy = Math.max(buy, sell - prices[i]);
            sell = newSell;
        }
        return Math.max(frozen, sell);
    }
}
// @lc code=end

