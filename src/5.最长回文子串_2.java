/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
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
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                if (dp[j][i]) {
                    return s.substring(j, i + j + 1);
                }
            }
        }
        return s;
    }
}
// @lc code=end

