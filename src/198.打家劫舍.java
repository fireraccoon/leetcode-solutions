/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int dp_0 = nums[0];
        int dp_1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = dp_1;
            dp_1 = Math.max(dp_1, dp_0 + nums[i]);
            dp_0 = tmp;
        }
        return dp_1;
    }
}
// @lc code=end

