/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            frequency.put(t.charAt(i), frequency.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (frequency.containsKey(s.charAt(right))) {
                while (!frequency.containsKey(s.charAt(left)) || isSolution(frequency, s.charAt(left)) == -1) {
                    if (frequency.containsKey(s.charAt(left))) {
                        frequency.put(s.charAt(left), frequency.get(s.charAt(left)) + 1);
                    }
                    left++;
                }
                frequency.put(s.charAt(right), frequency.get(s.charAt(right)) - 1);
                if (isSolution(frequency, s.charAt(left)) == 1) {
                    if (ans.length() == 0 || ans.length() >= right - left + 1) {
                        ans = s.substring(left, right + 1);
                    }
                    frequency.put(s.charAt(left), frequency.get(s.charAt(left)) + 1);
                    left++;
                }
            }
        }
        return ans;
    }
    int isSolution(Map<Character, Integer> map, Character firstChar) {
        int ans = 1;
        for (Character k: map.keySet()) {
            if (firstChar.equals(k) && map.get(k).compareTo(0) == -1) {
                return -1;
            } else if (map.get(k).compareTo(0) == 1) {
                ans = 0;
            }
        }
        return ans;
    }
}
// @lc code=end

