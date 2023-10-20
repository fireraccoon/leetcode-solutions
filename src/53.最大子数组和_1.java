/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        /** use nums as dp */
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
// @lc code=end

