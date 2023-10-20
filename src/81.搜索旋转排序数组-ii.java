/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left >> 1);
            if (nums[middle] == target) {
                return true;
            } else if (nums[left] == nums[middle] && nums[left] == nums[right]) {
                left++;
            } else if (nums[middle] > target) {
                if (nums[middle] >= nums[left] && nums[left] > target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (nums[middle] <= nums[right] && nums[right] < target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return false;
    }
}
// @lc code=end

