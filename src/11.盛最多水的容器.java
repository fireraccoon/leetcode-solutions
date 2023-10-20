/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int lp = 0, rp = height.length - 1;
        int area = 0;
        int lowest = 0;
        while (lp != rp) {
            area = Math.max(area, Math.min(height[lp], height[rp]) * (rp - lp));
            if (height[lp] <= height[rp]) {
                lowest = height[lp];
                while (++lp != rp && height[lp] <= lowest);
            } else {
                lowest = height[rp];
                while (--rp != lp && height[rp] <= lowest);
            }
        }
        return area;
    }
}
// @lc code=end

