/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] buys = new int[prices.length];
        int[] sells = new int[prices.length];
        buys[0] = -prices[0] - fee;
        sells[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buys[i] = Math.max(buys[i - 1], sells[i - 1] - prices[i] - fee);
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
        }
        return sells[prices.length - 1];
    }
}
// @lc code=end

