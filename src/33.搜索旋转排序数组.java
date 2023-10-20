/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
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
        return ans;
    }
}
// @lc code=end

