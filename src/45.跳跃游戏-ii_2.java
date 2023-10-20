/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        for (int i = 0; i + nums[i] < nums.length - 1;) {
            int nextJump = i + 1;
            int nextNextJump = nextJump + nums[Math.min(nextJump, nums.length - 1)];
            for (int j = i + 2; j <= i + nums[i]; j++) {
                int curNextNextJump = j + nums[Math.min(j, nums.length - 1)];
                if (nextNextJump <= curNextNextJump) {
                    nextJump = j;
                    nextNextJump = curNextNextJump;
                }
            }
            step++;
            i = nextJump;
        }
        step++;
        return step;
    }
}
// @lc code=end

