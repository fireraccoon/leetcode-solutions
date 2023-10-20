/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0], minSum = nums[0], sum = nums[0];
        int dp_max = nums[0], dp_min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp_max = Math.max(dp_max + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp_max);
            dp_min = Math.min(dp_min + nums[i], nums[i]);
            minSum = Math.min(minSum, dp_min);
        }
        return minSum == sum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
// @lc code=end

