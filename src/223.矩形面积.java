/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int combineArea = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        int leftBound = Math.max(ax1, bx1);
        int rightBound = Math.min(ax2, bx2);
        int topBound = Math.min(ay2, by2);
        int bottomBound = Math.max(ay1, by1);
        return combineArea - Math.max(0, rightBound - leftBound) * Math.max(0, topBound - bottomBound);
    }
}
// @lc code=end

