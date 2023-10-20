/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    int[] memory;
    public int numSquares(int n) {
        memory = new int[n + 1];
        Arrays.fill(memory, 1, n + 1, -1);
        return dfs(n);
    }
    int dfs(int n) {
        if (memory[n] != -1) {
            return memory[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, dfs(n - i * i));
        }
        memory[n] = min + 1;
        return memory[n];
    }
}
// @lc code=end

