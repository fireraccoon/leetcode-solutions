/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 0, bound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < bound) {
                ans++;
            } else {
                bound = intervals[i][1];
            }
        }
        return ans;
    }
}
// @lc code=end

