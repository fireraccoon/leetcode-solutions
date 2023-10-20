/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] shuffixMax = new int[n];
        for (int i = 0; i < n; i++) {
            prefixMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], prefixMax[i - 1]);
        }
        shuffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            shuffixMax[i] = i % k == 0 ? nums[i] : Math.max(nums[i], shuffixMax[i + 1]);
        }
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            ans[i] = Math.max(shuffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}
// @lc code=end

