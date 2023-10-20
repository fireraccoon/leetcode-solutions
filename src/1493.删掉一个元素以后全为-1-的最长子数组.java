/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, left = 0;
        boolean isDeleted = false;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                continue;
            }
            if (!isDeleted) {
                isDeleted = true;
            } else {
                ans = Math.max(ans, right - left - 1);
                while (left <= right && nums[left++] == 1);
            }
        }
        return Math.max(ans, nums.length - left - 1);
    }
}
// @lc code=end

