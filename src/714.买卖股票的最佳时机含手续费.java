/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i] + fee) {
                buy = prices[i] + fee;
            } else if (buy < prices[i]) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
// @lc code=end

