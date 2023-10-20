/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        double sqrt_5 = Math.sqrt(5D);
        return (int) ((Math.pow(0.5 + sqrt_5 / 2, n) - Math.pow(0.5 - sqrt_5 / 2, n)) / sqrt_5);
    }
}
// @lc code=end

