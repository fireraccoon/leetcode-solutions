/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        int ans = num / 1_000_000_000 + num / 100_000_000 % 10 + num / 10_000_000 % 10
            + num / 1_000_000 % 10 + num / 100_000 % 10 + num / 10_000 % 10
            + num / 1_000 % 10 + num / 100 % 10 + num / 10 % 10 + num % 10;
        ans = ans / 10 % 10 + ans % 10;
        return ans / 10 % 10 + ans % 10;
    }
}
// @lc code=end

