/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int diffMask = xor == Integer.MIN_VALUE ? xor : xor & -xor;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diffMask) == 0) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end

