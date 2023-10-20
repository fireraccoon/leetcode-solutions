/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carries = a & b;
            a = a ^ b;
            b = carries << 1;
        }
        return a;
    }
}
// @lc code=end

