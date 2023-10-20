/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        int numBits = n == 0 ? 1 : 0;
        for (int base = 1; base <= n; base *= 10) {
            numBits++;
        }

        int[] dp = new int[numBits + 1];
        dp[0] = 0;
        int base = 1;
        for (int i = 1; i < numBits; i++) {
            dp[i] = 10 * dp[i - 1] + base;
            base *= 10;
        }
        dp[numBits] = 10 * dp[numBits - 1] + base;

        int ans = 0;
        for (int i = numBits; i >= 1; i--) {
            int digit = n / base % 10;
            ans += dp[i - 1] * digit;
            if (digit > 1) {
                ans += base;
            } else if (digit == 1) {
                ans += n % base + 1;
            }
            base /= 10;
        }
        return ans;
    }
}
// @lc code=end

