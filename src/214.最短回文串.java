/*
 * @lc app=leetcode.cn id=214 lang=java
 *
 * [214] 最短回文串
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        String expandString = sb.toString();
        n = expandString.length();
        int maxRight = 0, maxRightIndex = 0;
        int maxLength = 0;
        int[] lengths = new int[n];
        for (int i = 1; i < n; i++) {
            int bias = i >= maxRight ? 0 :
                Math.min(lengths[2 * maxRightIndex - i], maxRight - i);
            lengths[i] = expand(expandString, i, bias);
            if (lengths[i] > maxLength && i == lengths[i]) {
                maxLength = lengths[i];
            }
            if (lengths[i] + i > maxRight) {
                maxRight = lengths[i] + i;
                maxRightIndex = i;
            }
        }
        sb = new StringBuilder();
        for (int i = maxLength * 2 + 1; i < n; i += 2) {
            sb.append(expandString.charAt(i));
        }
        return sb.reverse().append(s).toString();
    }
    int expand(String s, int index, int bias) {
        bias++;
        for (int n = s.length(); index >= bias && index + bias < n
            && s.charAt(index - bias) == s.charAt(index + bias); bias++);
        return --bias;
    }
}
// @lc code=end

