/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[j][i] == 0) {
                    dp[j] += dp[j-1];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[m-1];
    }
}
// @lc code=end

