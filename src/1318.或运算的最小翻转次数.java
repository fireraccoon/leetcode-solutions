/*
 * @lc app=leetcode.cn id=1318 lang=java
 *
 * [1318] 或运算的最小翻转次数
 */

// @lc code=start
class Solution {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ~c);
    }
}
// @lc code=end

