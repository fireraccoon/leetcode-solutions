/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int bitCount = 0;
            for (int j = 0; j < n; j++) {
                bitCount += (nums[j] >> i) & 1;
            }
            if (bitCount > n >> 1) {
                ans |= 1 << i;
                continue;
            }
        }
        return ans;
    }
}
// @lc code=end

