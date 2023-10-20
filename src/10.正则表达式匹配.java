/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start

/*
 * f[i][j] 第i个待匹配字符匹配第j个字符的匹配情况
 * 1. p[j] == '*'
 *  1.1 match(s[i],p[j-1]), f[i][j] = f[i-1]f[j] || f[i]f[j-2] (可以匹配也可以丢掉两个字符)
 *  1.2 !match(s[i],p[j-1]), f[i][j] = f[i]f[j-2] (丢掉两个字符)
 * 2. p[j] != '*'
 *  2.1 match(s[i],p[j]), f[i][j] = f[i-1][j-1]
 *  2.2 !match(s[i],p[j]), f[i][j] = false
 * 
 * i >= 1, j >= 1
 * f[0][0] = 0
 * f[0][j] = p[j] == '*' ? f[0][j-2] : false, 特殊性:.*可匹配空,故从0开始
 * p[j] == '*' -> j >= 2, 因为题目无不合法匹配
 * f[i][0] = false可不用, 1 <= p.length <= 20
 */

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (i != 0 && isCharMatch(s.charAt(i-1), p.charAt(j-2))) {
                        dp[i][j] |= dp[i-1][j];
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = isCharMatch(s.charAt(i-1), p.charAt(j-1)) ? dp[i-1][j-1] : false;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    boolean isCharMatch(char sc, char pc) {
        return pc == '.' ? true : sc == pc;
    }
}

// @lc code=end

