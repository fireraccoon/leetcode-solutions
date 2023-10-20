/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */
// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        long[] nums = new long[3];
        int[] factors = new int[] { 2, 3, 5 };
        int[] pointers = new int[] { 0, 0, 0 };
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                nums[j] = (long) dp[pointers[j]] * factors[j];
                min = Math.min(min, nums[j]);
            }
            dp[i] = (int) min;
            for (int j = 0; j < 3; j++) {
                if (nums[j] == min) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

