/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                isPalindrome[j][i] = s.charAt(j) == s.charAt(i + j)
                    && (i == 1 || isPalindrome[j + 1][i - 2]);
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = isPalindrome[0][i] ? 0 : i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (isPalindrome[j][i - j]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

