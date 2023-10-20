/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] minimumHPs = new int[m][n];
        minimumHPs[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            minimumHPs[i][n - 1] = Math.max(1, minimumHPs[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            minimumHPs[m - 1][i] = Math.max(1, minimumHPs[m - 1][i + 1] - dungeon[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                minimumHPs[i][j] = Math.max(
                    1,
                    Math.min(
                        minimumHPs[i + 1][j],
                        minimumHPs[i][j + 1]
                    ) - dungeon[i][j]
                );
            }
        }
        return minimumHPs[0][0];
    }
}
// @lc code=end

