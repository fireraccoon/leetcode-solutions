/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][i - 2]);
            }
        }
        dfs(ans, new LinkedList<>(), 0, s);
        return ans;
    }
    void dfs(List<List<String>> ans, Deque<String> node, int pointer, String s) {
        if (pointer >= dp.length) {
            ans.add(new ArrayList<>(node));
            return;
        }
        for (int i = pointer; i < dp.length; i++) {
            if (dp[pointer][i - pointer]) {
                node.offerLast(s.substring(pointer, i + 1));
                dfs(ans, node, i + 1, s);
                node.pollLast();
            }
        }
    }
}
// @lc code=end

