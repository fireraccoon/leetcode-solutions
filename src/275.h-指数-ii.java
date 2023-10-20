/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (citations[middle] < citations.length - middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return citations.length - right;
    }
}
// @lc code=end

