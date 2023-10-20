/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int index = 0;
        int i;
        for (i = 0; index < 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                ans[index++] = nums[i];
            }
        }
        for (i--; index < 2; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                ans[index++] = nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end

