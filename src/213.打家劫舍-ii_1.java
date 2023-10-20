/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 2][1]);
    }
}
// @lc code=end

