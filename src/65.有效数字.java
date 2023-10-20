/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        int[][] dfaTable = new int[][] {
            {1, 2, 3, -1},
            {-1, 2, 3, -1},
            {-1, 2, 4, 5},
            {-1, 6, -1, -1},
            {-1, 7, -1, 5},
            {8, 9, -1, -1},
            {-1, 6, -1, 5},
            {-1, 7, -1, 5},
            {-1, 9, -1, -1},
            {-1, 9, -1, -1}
        };
        int[] endOfStates = new int[] {
            2, 4, 6, 7, 9
        };
        int state = 0;
        for (int i = 0; i < s.length() && state != -1; i++) {
            int charIndex = getCharIndex(s.charAt(i));
            if (charIndex == -1) {
                return false;
            }
            state = dfaTable[state][charIndex];
        }
        for (int i = 0; i < endOfStates.length; i++) {
            if (state == endOfStates[i]) {
                return true;
            }
        }
        return false;
    }
    int getCharIndex(char c) {
        if (c == '-' || c == '+') {
            return 0;
        } else if (c >= '0' && c <= '9') {
            return 1;
        } else if (c == '.') {
            return 2;
        } else if (c == 'e' || c == 'E') {
            return 3;
        } else {
            return -1;
        }
    }
}
// @lc code=end

