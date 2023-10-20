/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counts[n]++;
            } else {
                counts[citations[i]]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += counts[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
// @lc code=end

