/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        int ans = 0;
        int base = 1;
        while (base <= n) {
            ans += n / (base * 10) * base;
            if (n % (base * 10) >= base) {
                ans += Math.min(n % (base * 10) - base + 1, base);
            }
            base *= 10;
        }
        return ans;
    }
}
// @lc code=end

