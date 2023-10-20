/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int step = 0;
        for (int i = nums.length - 1; i > 0;) {
            int nextJump = nums.length - 1;
            for (int j = nums.length - 2; j >= 0; j--) {
                if (nums[j] + j >= i) {
                    nextJump = j;
                }
            }
            step++;
            i = nextJump;
        }
        return step;
    }
}
// @lc code=end

