/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int ans = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int bitsCount = 0;
            bitsCount += nums[0] >>> i & 1;
            for (int j = 1; j < nums.length; j++) {
                bitsCount += (nums[j] >>> i & 1) - (j >>> i & 1);
            }
            if (bitsCount > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
// @lc code=end

