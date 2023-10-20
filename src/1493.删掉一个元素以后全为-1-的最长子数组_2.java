/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] leftOneLongests = new int[n];
        leftOneLongests[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftOneLongests[i] = nums[i] == 1 ? leftOneLongests[i - 1] + 1 : 0;
        }
        int ans = 0, rightOneLongest = 0;
        for (int i = n - 1; i > 0; i--) {
            ans = Math.max(ans, leftOneLongests[i - 1] + rightOneLongest);
            rightOneLongest = nums[i] == 1 ? rightOneLongest + 1 : 0;
        }
        return Math.max(ans, rightOneLongest);
    }
}
// @lc code=end

