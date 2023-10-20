/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        long[] nums = new long[primes.length];
        int[] pointers = new int[primes.length];
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                nums[j] = (long) dp[pointers[j]] * primes[j];
                min = Math.min(min, nums[j]);
            }
            dp[i] = (int) min;
            for (int j = 0; j < primes.length; j++) {
                if (nums[j] == min) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

