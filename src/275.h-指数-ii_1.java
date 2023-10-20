/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int h = 0;
        for (int i = citations.length - 1; i >= 0 && citations[i] > h; i--) {
            h++;
        }
        return h;
    }
}
// @lc code=end

