/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */
// @lc code=start
class Solution {
    public int climbStairs(int n) {
        double ans = 1 / Math.sqrt(5)
            * (Math.pow((1 + Math.sqrt(5)) / 2, n + 1)
            - Math.pow((1 - Math.sqrt(5)) / 2, n + 1));
        return (int) ans;
    }
}
// @lc code=end
