/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int largestAltitude = 0, altitude = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            largestAltitude = Math.max(largestAltitude, altitude);
        }
        return largestAltitude;
    }
}
// @lc code=end

