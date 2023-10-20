/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */
// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int prefixMax = nums[0];
        int[] shuffixMax = new int[k];
        for (int i = 1; i < k - 1; i++) {
            prefixMax = Math.max(nums[i], prefixMax);
        }
        for (int i = 0; i <= n - k; i++) {
            if (i % k == 0) {
                shuffixMax[k - 1] = nums[Math.min(i + k - 1, n - 1)];
                for (int j = Math.min(i + k - 2, n - 2); j >= i; j--) {
                    shuffixMax[j % k] = Math.max(nums[j], shuffixMax[j % k + 1]);
                }
            }
            prefixMax = (i + k - 1) % k == 0 ? nums[i + k - 1] : Math.max(nums[i + k - 1], prefixMax);
            ans[i] = Math.max(prefixMax, shuffixMax[i % k]);
        }
        return ans;
    }
}
// @lc code=end

