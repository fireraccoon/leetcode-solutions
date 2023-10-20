/*
 * @lc app=leetcode.cn id=2390 lang=java
 *
 * [2390] 从字符串中移除星号
 */

// @lc code=start
class Solution {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '*') {
                stack.append(c);
            } else {
                stack.deleteCharAt(stack.length() - 1);
            }
        }
        return stack.toString();
    }
}
// @lc code=end

