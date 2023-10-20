/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] zipMinimumHPs = new int[n];
        zipMinimumHPs[n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            zipMinimumHPs[i] = Math.max(1, zipMinimumHPs[i + 1] - dungeon[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            zipMinimumHPs[n - 1] = Math.max(1, zipMinimumHPs[n - 1] - dungeon[i][n - 1]);
            for (int j = n - 2; j >= 0; j--) {
                zipMinimumHPs[j] = Math.max(
                    1, 
                    Math.min(zipMinimumHPs[j], zipMinimumHPs[j + 1]) - dungeon[i][j]
                );
            }
        }
        return zipMinimumHPs[0];
    }
}
// @lc code=end

