/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 买卖股票的最佳时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buys = new int[n];
        int[] frozens = new int[n];
        int[] sells = new int[n];
        buys[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buys[i] = Math.max(buys[i - 1], sells[i - 1] - prices[i]);
            frozens[i] = buys[i - 1] + prices[i];
            sells[i] = Math.max(sells[i - 1], frozens[i - 1]);
        }
        return Math.max(frozens[n - 1], sells[n - 1]);
    }
}
// @lc code=end

