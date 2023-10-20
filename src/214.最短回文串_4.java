/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][i] = dp[j + 1][i - 2] && s.charAt(j) == s.charAt(j + i);
            }
        }
        int maxPalindromeLength = 0;
        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                maxPalindromeLength = i;
            }
        }
        return new StringBuilder(s.substring(maxPalindromeLength + 1))
            .reverse().append(s).toString();
    }
}
// @lc code=end

