/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int dp_0_0 = 0;
        int dp_0_1 = nums[0];
        int dp_1_0 = nums[1];
        int dp_1_1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = dp_1_0;
            dp_1_0 = Math.max(dp_1_0, dp_0_0 + nums[i]);
            dp_0_0 = tmp;
            tmp = dp_1_1;
            dp_1_1 = Math.max(dp_1_1, dp_0_1 + nums[i]);
            dp_0_1 = tmp;
        }
        return Math.max(dp_1_0, dp_0_1);
    }
}
// @lc code=end

