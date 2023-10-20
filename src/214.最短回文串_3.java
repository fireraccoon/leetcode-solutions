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
        int maxLength = 0;
        for (int i = 0; i <= n / 2; i++) {
            int length = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if ((length - 1) / 2 == i) {
                maxLength = length;
            }
        }
        return new StringBuilder(s.substring(maxLength))
            .reverse().append(s).toString();
    }
    int expand(String s, int begin, int end) {
        for (int n = s.length(); begin >= 0 && end < n && s.charAt(begin) == s.charAt(end);) {
            begin--;
            end++;
        }
        return end - begin - 1;
    }
}
// @lc code=end

