/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0 && citations[i] > h; i--) {
            h++;
        }
        return h;
    }
}
// @lc code=end

