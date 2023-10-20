/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

/**
 * dp[i, j]: i长的s串对于j长的p串的匹配情况
 * 1. p[j] = '*', dp[i, j] = dp[i-1, j-1] || dp[i-1, j] || dp[i][j-1]
 * 2. p[j] = '?', dp[i, j] = dp[i-1, j-1]
 * 3. other, dp[i, j] = dp[i-1, j-1] && s[i] == p[j]
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        // for (int i = 1; i <= m; i++) {
        //     dp[i][0] = false;
        // }
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i-1];
            } else {
                // dp[0][i] = false;
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                } else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j-1] && s.charAt(i - 1) == p.charAt(j - 1);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

