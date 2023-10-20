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
        int[] pi = new int[n];
        pi[0] = 0;
        for (int i = 1; i < n; i++) {
            int bias = pi[i - 1];
            while (bias > 0 && s.charAt(bias) != s.charAt(i)) {
                bias = pi[bias - 1];
            }
            pi[i] = bias;
            if (s.charAt(bias) == s.charAt(i)) {
                pi[i]++;
            }
        }
        int i = n - 1, j = 0;
        while (i >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                i--;
            } else if (j > 0) {
                j = pi[j - 1];
            } else {
                i--;
            }
        }
        return new StringBuilder(s.substring(j))
            .reverse().append(s).toString();
    }
}
// @lc code=end

