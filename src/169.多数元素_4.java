/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
// @lc code=end

