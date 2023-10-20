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
        int ansL = -1, ansR = -1;
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int left = 0, right = 0, count = 0; right < s.length(); right++) {
            if (need.containsKey(s.charAt(right))) {
                int freq = need.get(s.charAt(right));
                if (freq > 0) {
                    count++;
                }
                need.put(s.charAt(right), freq - 1);
            }
            if (count == t.length()) {
                while (true) {
                    int freq = need.getOrDefault(s.charAt(left), 0);
                    if (!need.containsKey(s.charAt(left))) {
                        left++;
                    } else if (freq < 0) {
                        need.put(s.charAt(left), freq + 1);
                        left++;
                    } else {
                        break;
                    }
                }
                if (ansL == -1 || ansR - ansL > right - left) {
                    ansL = left;
                    ansR = right;
                }
                need.put(s.charAt(left), need.get(s.charAt(left)) + 1);
                left++;
                count--;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }
}
// @lc code=end

