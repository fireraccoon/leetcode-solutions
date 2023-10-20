/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int boughtPrice = prices[0];
        int maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < maxPrice) {
                ans += maxPrice - boughtPrice;
                boughtPrice = prices[i];
                maxPrice = prices[i];
            } else {
                maxPrice = prices[i];
            }
        }
        ans += maxPrice - boughtPrice;
        return ans;
    }
}
// @lc code=end

