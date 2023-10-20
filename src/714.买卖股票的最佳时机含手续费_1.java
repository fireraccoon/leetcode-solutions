/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0] - fee, sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int nextBuy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, buy + prices[i]);
            buy = nextBuy;
        }
        return sell;
    }
}
// @lc code=end

