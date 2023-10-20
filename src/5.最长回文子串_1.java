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
        int begin = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            int length = Math.max(expandLength(s, i, i), expandLength(s, i, i + 1));
            if (length > maxLength) {
                maxLength = length;
                begin = i - (length - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLength);
    }
    int expandLength(String s, int start, int end) {
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
// @lc code=end

