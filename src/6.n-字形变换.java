/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] N 字形变换
 */

// @lc code=start

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }
        int row =  0;
        boolean reverse = false;
        for (int i = 0; i < s.length(); i++) {
            res[row].append(s.charAt(i));
            if (row == numRows - 1) {
                reverse = true;
            } else if (row == 0) {
                reverse = false;
            }
            row += reverse ? -1 : 1;
        }
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }
}
// @lc code=end

