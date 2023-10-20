/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int bitSum = 0;
            for (int j = 0; j < nums.length; j++) {
                bitSum += (nums[j] >> i) & 1;
            }
            if (bitSum % 3 != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
// @lc code=end

