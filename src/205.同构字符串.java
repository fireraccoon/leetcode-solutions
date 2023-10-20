/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    private final static char DEFAULT_CHAR = Character.MAX_VALUE;
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        char[] sMapToT = new char[128];
        char[] tMapToS = new char[128];
        Arrays.fill(sMapToT, DEFAULT_CHAR);
        Arrays.fill(tMapToS, DEFAULT_CHAR);
        for (int i = 0; i < n; i++) {
            char keyS = s.charAt(i);
            char keyT = t.charAt(i);
            if (sMapToT[keyS] == DEFAULT_CHAR) {
                sMapToT[keyS] = keyT;
            } else if (sMapToT[keyS] != keyT) {
                return false;
            }
            if (tMapToS[keyT] == DEFAULT_CHAR) {
                tMapToS[keyT] = keyS;
            } else if (tMapToS[keyT] != keyS) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

