/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start_index = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start_index = Math.max(map.get(s.charAt(i)) + 1, start_index);
            }
            max = Math.max(max, i - start_index + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
// @lc code=end

