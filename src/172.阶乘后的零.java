/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int pow = 5; pow <= n; pow *= 5) {
            ans += n / pow;
        }
        return ans;
    }
}
// @lc code=end

