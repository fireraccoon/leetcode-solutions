/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                for (int j = 0; j <= n - length; j++) {
                    for (int k = 1; k < length; k++) {
                        if (dp[i][j][k - 1] && dp[i + k][j + k][length - k - 1]
                            || dp[i][j + length - k][k - 1] && dp[i + k][j][length - k - 1]) {
                            dp[i][j][length - 1] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n - 1];
    }
}
// @lc code=end

