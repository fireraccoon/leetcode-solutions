/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        for (int right = 0; right < chars.length; right++) {
            if (chars[right] != ' ' || length > 0 && chars[length - 1] != ' ') {
                chars[length++] = chars[right];
            }
        }
        length -= chars[length - 1] == ' ' ? 1 : 0;
        reverseString(chars, 0, length);
        for (int left = 0, right = 0; right < length; right++) {
            if (right + 1 == length || chars[right + 1] == ' ') {
                reverseString(chars, left, right + 1);
                left = right + 2;
                right++;
            }
        }
        return String.copyValueOf(chars, 0, length);
    }
    void reverseString(char[] chars, int begin, int end) {
        for (int left = begin, right = end - 1; left < right;) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }
}
// @lc code=end

