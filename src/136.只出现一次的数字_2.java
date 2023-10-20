/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i + 1 == nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
// @lc code=end

