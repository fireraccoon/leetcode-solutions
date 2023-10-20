/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        int leftMax = height[0], rightMax = height[n-1];
        int left = 0, right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                int h = Math.min(leftMax, rightMax) - height[left];
                if (h > 0) {
                    ans += h;
                }
                leftMax = Math.max(leftMax, height[++left]);
            } else {
                int h = Math.min(leftMax, rightMax) - height[right];
                if (h > 0) {
                    ans += h;
                }
                rightMax = Math.max(rightMax, height[--right]);
            }
        }
        return ans;
    }
}
// @lc code=end

