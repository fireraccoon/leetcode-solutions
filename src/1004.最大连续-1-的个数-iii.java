/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        for (int right = 0, extraOne = k; right < nums.length; right++) {
            if (nums[right] == 1) {
                continue;
            }
            if (extraOne == 0) {
                ans = Math.max(ans, right - left);
                while (left <= right && nums[left++] == 1);
            } else {
                extraOne--;
            }
        }
        return Math.max(ans, nums.length - left);
    }
}
// @lc code=end

