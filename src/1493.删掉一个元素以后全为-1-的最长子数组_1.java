/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        for (int i = 0, leftOneLongest = 0, longest = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                longest = leftOneLongest;
                leftOneLongest = 0;
            } else {
                leftOneLongest++;
                longest++;
            }
            ans = Math.max(ans, longest);
        }
        return ans == nums.length ? ans - 1 : ans;
    }
}
// @lc code=end

