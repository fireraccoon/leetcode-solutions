/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> sMapToT = new HashMap<>();
        Map<Character, Character> tMapToS = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character c = sMapToT.putIfAbsent(s.charAt(i), t.charAt(i));
            if (c != null && c != t.charAt(i)) {
                return false;
            }
            c = tMapToS.putIfAbsent(t.charAt(i), s.charAt(i));
            if (c != null && c != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

