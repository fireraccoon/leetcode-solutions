/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        return Integer.bitCount(n) == 1 && n != Integer.MIN_VALUE;
    }
}
// @lc code=end

