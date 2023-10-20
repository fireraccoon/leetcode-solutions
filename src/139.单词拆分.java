/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> words = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                dp[i] = dp[j] && words.contains(s.substring(j, i));
            }
        }
        return dp[n];
    }
}
// @lc code=end

