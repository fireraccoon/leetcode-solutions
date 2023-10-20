/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        for (boolean slowAdded = false; ; slowAdded = !slowAdded) {
            fast = nums[fast];
            if (slowAdded) {
                slow = nums[slow];
                if (slow == fast) {
                    break;
                }
            }
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// @lc code=end

