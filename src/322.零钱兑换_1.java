/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    int[] memory;
    public int coinChange(int[] coins, int amount) {
        memory = new int[amount + 1];
        Arrays.fill(memory, -2);
        memory[0] = 0;
        return dfs(coins, amount);
    }
    int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (memory[amount] != -2) {
            return memory[amount];
        }
        int minAns = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int result = dfs(coins, amount - coins[i]);
            if (result != -1) {
                minAns = Math.min(minAns, result);
            }
        }
        memory[amount] = minAns == Integer.MAX_VALUE ? -1 : minAns + 1;
        return memory[amount];
    }
}
// @lc code=end

