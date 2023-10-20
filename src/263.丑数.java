/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        int[] factors = new int[] { 2, 3, 5 };
        for (int i = 0; i < 3; i++) {
            while (n % factors[i] == 0) {
                n /= factors[i];
            }
        }
        return n == 1;
    }
}
// @lc code=end

