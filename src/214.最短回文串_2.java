/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    private static final long BKDR_BASE = 131;
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        long hash = 0, hashReverse = 0, pow = 1;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            hash = hash * BKDR_BASE + (s.charAt(i) - 'a');
            hashReverse += (s.charAt(i) - 'a') * pow;
            if (hash == hashReverse) {
                maxLength = i;
            }
            pow *= BKDR_BASE;
        }
        return new StringBuilder(s.substring(maxLength + 1))
            .reverse().append(s).toString();
    }
}
// @lc code=end

