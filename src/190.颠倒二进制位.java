/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = n >>> 1 & 0x55555555 | n << 1 & 0xaaaaaaaa;
        n = n >>> 2 & 0x33333333 | n << 2 & 0xcccccccc;
        n = n >>> 4 & 0x0f0f0f0f | n << 4 & 0xf0f0f0f0;
        n = n >>> 8 & 0x00ff00ff | n << 8 & 0xff00ff00;
        return n >>> 16 | n << 16;
    }
}
// @lc code=end

