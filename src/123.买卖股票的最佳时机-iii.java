/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[] { -prices[0], -prices[0] };
        int[] sell = new int[2];
        for (int i = 1; i < prices.length; i++) {
            sell[1] = Math.max(sell[1], buy[1] + prices[i]);
            buy[1] = Math.max(buy[1], sell[0] - prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            buy[0] = Math.max(buy[0], -prices[i]);
        }
        return Math.max(sell[0], sell[1]);
    }
}
// @lc code=end

