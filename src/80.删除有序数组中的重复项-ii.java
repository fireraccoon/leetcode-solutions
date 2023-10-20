/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int correctLength = 1;
        for (int i = 1, duplicateLength = 0; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicateLength++;
            } else {
                duplicateLength = 0;
            }
            if (duplicateLength < 2) {
                nums[correctLength] = nums[i];
                correctLength++;
            }
        }
        return correctLength;
    }
}
// @lc code=end

