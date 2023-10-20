/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int count = 1, pointer = 0;
        for (int i = 1; i <= n; i++) {
            if (i != n && chars[i] == chars[i - 1]) {
                count++;
            } else if (count > 1) {
                chars[pointer++] = chars[i - 1];
                int start = pointer;
                while (count > 0) {
                    chars[pointer++] = (char) (count % 10 + '0');
                    count /= 10;
                }
                reverse(chars, start, pointer - 1);
                count = 1;
            } else {
                chars[pointer++] = chars[i - 1];
            }
        }
        return pointer;
    }
    void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
// @lc code=end

