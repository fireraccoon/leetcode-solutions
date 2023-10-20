/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (countSmaller(nums, middle) <= middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }
    int countSmaller(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

