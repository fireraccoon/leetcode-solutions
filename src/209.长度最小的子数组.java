/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int begin = 0, end = 0, sum = 0; end < n; end++) {
            sum += nums[end];
            while (sum >= target && begin <= end) {
                ans = Math.min(ans, end - begin + 1);
                sum -= nums[begin];
                begin++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
// @lc code=end

