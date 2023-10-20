/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int middle = (left + right + 1) >>> 1;
            if (countPapers(citations, middle) >= middle) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
    int countPapers(int[] citations, int h) {
        int count = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

