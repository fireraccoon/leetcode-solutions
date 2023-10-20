/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int maxl = 0, maxr = 0;
        int nbegin = 0, nend = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                nbegin += 1;
            } else {
                nend += 1;
                if (nbegin == nend) {
                    maxl = Math.max(maxl, nbegin << 1);
                } else if (nend > nbegin) {
                    nbegin = 0;
                    nend = 0;
                }
            }
        }
        nbegin = nend = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                nbegin += 1;
            } else {
                nend += 1;
                if (nbegin == nend) {
                    maxr = Math.max(maxr, nbegin << 1);
                } else if (nend > nbegin) {
                    nbegin = 0;
                    nend = 0;
                }
            }
        }
        return Math.max(maxl, maxr);
    }
}
// @lc code=end

