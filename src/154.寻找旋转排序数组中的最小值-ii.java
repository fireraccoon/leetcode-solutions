/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int left = 1, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[middle - 1]) {
                return nums[middle];
            } else if (nums[middle] == nums[middle - 1]) {
                if (nums[left] > nums[right]) {
                    left++;
                } else {
                    right--;
                }
            } else if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

