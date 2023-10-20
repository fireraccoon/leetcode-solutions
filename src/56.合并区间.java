/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int pointer = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[pointer][1] >= intervals[i][1]) {
                continue;
            }
            if (intervals[pointer][1] >= intervals[i][0]) {
                intervals[pointer][1] = intervals[i][1];
            } else {
                ans.add(intervals[pointer]);
                pointer = i;
            }
        }
        ans.add(intervals[pointer]);
        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end

