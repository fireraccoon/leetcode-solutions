/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1)
                    || dp[i][j - 1];
            }
        }
        return dp[n][m];
    }
}
// @lc code=end

