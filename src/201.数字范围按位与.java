/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int diff = left ^ right;
        int shift = 0;
        while (diff != 0) {
            shift++;
            diff >>= 1;
        }
        return right & 0xffffffff << shift;
    }
}
// @lc code=end

