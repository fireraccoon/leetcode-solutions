/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            Character key = t.charAt(i);
            map.put(key, map.getOrDefault(key, 0) - 1);
            if (map.get(key) < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

