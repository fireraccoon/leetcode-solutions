/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            ans = ans << 1 | n & 1;
            n >>>= 1;
        }
        return ans;
    }
}
// @lc code=end

