/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ~a & (b ^ nums[i]);
            a = a & ~b & ~nums[i] | ~a & b & nums[i];
            b = ans;
        }
        return ans;
    }
}
// @lc code=end

