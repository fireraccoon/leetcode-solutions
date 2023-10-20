/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; i++) {
            if (i >= nums.length) {
                nums[j++] = 0;
            } else if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
    }
}
// @lc code=end

