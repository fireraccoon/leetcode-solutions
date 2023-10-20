/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                ans = Math.max(ans, (double) sum / k);
                sum -= nums[i - k + 1];
            }
        }
        return ans;
    }
}
// @lc code=end

