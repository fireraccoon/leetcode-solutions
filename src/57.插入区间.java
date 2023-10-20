/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int pointer = 0;
        for (; pointer < intervals.length && intervals[pointer][1] < newInterval[0]; pointer++) {
            ans.add(intervals[pointer]);
        }
        if (pointer < intervals.length && intervals[pointer][0] <= newInterval[1]) {
            do {
                newInterval[0] = Math.min(newInterval[0], intervals[pointer][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[pointer][1]);
                pointer++;
            } while (pointer < intervals.length && intervals[pointer][0] <= newInterval[1]);
        }
        ans.add(newInterval);
        for (; pointer < intervals.length; pointer++) {
            ans.add(intervals[pointer]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end

