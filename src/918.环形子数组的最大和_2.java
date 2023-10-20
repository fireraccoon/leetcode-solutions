/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, ans = nums[0];
        int leftSum = nums[0], maxSum = nums[0];
        int[] leftSums = new int[n];
        leftSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            ans = Math.max(ans, maxSum);
            leftSum += nums[i];
            leftSums[i] = Math.max(leftSum, leftSums[i - 1]);
        }
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            ans = Math.max(ans, leftSums[i - 1] + rightSum);
        }
        return ans;
    }
}
// @lc code=end

