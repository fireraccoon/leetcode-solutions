/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    int[][] memory;
    public int maxCoins(int[] nums) {
        memory = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memory[i], -1);
        }
        return dfs(nums, 0, nums.length - 1);
    }
    int dfs(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (memory[left][right] == -1) {
            int prevMulNext = (left == 0 ? 1 : nums[left - 1]) * (right == nums.length - 1 ? 1 : nums[right + 1]);
            for (int i = left; i <= right; i++) {
                memory[left][right] = Math.max(memory[left][right],
                    dfs(nums, left, i - 1) + nums[i] * prevMulNext + dfs(nums, i + 1, right));
            }
        }
        return memory[left][right];
    }
}
// @lc code=end

