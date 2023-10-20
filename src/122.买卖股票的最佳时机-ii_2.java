/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int unboughtProfit = 0;
        int boughtProfit = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int todayUnboughtProfit = Math.max(unboughtProfit, boughtProfit + prices[i]);
            boughtProfit = Math.max(unboughtProfit - prices[i], boughtProfit);
            unboughtProfit = todayUnboughtProfit;
        }
        return unboughtProfit;
    }
}
// @lc code=end

