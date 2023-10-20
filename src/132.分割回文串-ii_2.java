/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    boolean[][] dp;
    int ans = Integer.MAX_VALUE;
    public int minCut(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i + j) && (i == 1 || dp[j + 1][i - 2]);
            }
        }
        dfs(s, 0, -1);
        return ans;
    }
    void dfs(String s, int pointer, int deepth) {
        if (ans < deepth) {
            return;
        } else if (pointer >= s.length()) {
            ans = deepth;
            return;
        }
        for (int i = s.length() - 1; i >= pointer; i--) {
            if (dp[pointer][i - pointer]) {
                dfs(s, i + 1, deepth + 1);
            }
        }
    }
}
// @lc code=end

