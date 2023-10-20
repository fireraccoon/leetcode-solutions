/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 0; len < n; len++) {
            int left = 0, right = len;
            while (right < n) {
                int prevMulNext = (left == 0 ? 1 : nums[left - 1]) * (right == n - 1 ? 1 : nums[right + 1]);
                if (len == 0) {
                    dp[left][right] = nums[left] * prevMulNext;
                } else {
                    dp[left][right] = Math.max(nums[left] * prevMulNext + dp[left + 1][right], 
                        nums[right] * prevMulNext + dp[left][right - 1]);
                }
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][i - 1] + nums[i] * prevMulNext + dp[i + 1][right]);
                }
                left++;
                right++;
            }
        }
        return dp[0][n - 1];
    }
}
// @lc code=end

