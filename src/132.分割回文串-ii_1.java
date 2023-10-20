/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {
    boolean dp[][];
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
        return bfs(s);
    }
    int bfs(String s) {
        int deepth = 0, n = s.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int pointer = queue.poll();
                if (dp[pointer][n - pointer - 1]) {
                    return deepth;
                }
                for (int j = 0; j < n - pointer - 1; j++) {
                    if (dp[pointer][j]) {
                        queue.offer(pointer + j + 1);
                    }
                }
            }
            deepth++;
        }
        return deepth;
    }
}
// @lc code=end

