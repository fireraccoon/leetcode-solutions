/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        s = sb.toString();
        n = s.length();
        int maxRight = 0, maxRightIndex = 0;
        int maxLength = 0, ansIndex = 0;
        int[] lengths = new int[n];
        for (int i = 1; i < n; i++) {
            int bias = maxRight <= i ? 0 :
                Math.min(lengths[2 * maxRightIndex - i], maxRight - i);
            lengths[i] = expand(s, i, bias);
            if (lengths[i] > maxLength) {
                maxLength = lengths[i];
                ansIndex = i;
            }
            if (lengths[i] + i > maxRight) {
                maxRight = lengths[i] + i;
                maxRightIndex = i;
            }
        }
        sb = new StringBuilder();
        for (int i = ansIndex - maxLength + 1; i < ansIndex + maxLength; i += 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    int expand(String s, int index, int bias) {
        bias++;
        for (int n = s.length(); index >= bias && index + bias < n
            && s.charAt(index + bias) == s.charAt(index - bias); bias++);
        return --bias;
    }
}
// @lc code=end

