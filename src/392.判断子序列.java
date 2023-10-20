/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[m][i] = m;
        }
        for (int i = m - 1; i >= 0; i--) {
            int c = t.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                dp[i][j] = c == j ? i : dp[i + 1][j];
            }
        }
        int i = 0, j = 0;
        while (i < n) {
            j = dp[j][s.charAt(i) - 'a'];
            if (j == m) {
                break;
            }
            i++;
            j++;
        }
        return i == n;
    }
}
// @lc code=end

