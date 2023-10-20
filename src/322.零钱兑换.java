/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int lastAmount = i - coins[j];
                if (lastAmount >= 0 && dp[lastAmount] != -1) {
                    count = Math.min(count, dp[lastAmount] + 1);
                }
            }
            dp[i] = count == Integer.MAX_VALUE ? -1 : count;
        }
        return dp[amount];
    }
}
// @lc code=end

