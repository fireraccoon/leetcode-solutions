/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wil = words[0].length(), wl = words.length, sl = s.length();
        Map<String, Integer> memory = new HashMap<>();
        for (int i = 0; i < wil; i++) {
            for (String word: words) {
                memory.put(word, memory.getOrDefault(word, 0) - 1);
            }
            int fullWindowI = i + (wl - 1) * wil;
            for (int j = i; j + wil <= sl; j += wil) {
                String window = s.substring(j, j + wil);
                int v = memory.getOrDefault(window, 0) + 1;
                if (v == 0) {
                    memory.remove(window);
                } else {
                    memory.put(window, v);
                }
                if (j >= fullWindowI) {
                    if (memory.isEmpty()) {
                        ans.add(j - (wl - 1) * wil);
                    }
                    window = s.substring(j - (wl - 1) * wil, j - (wl - 2) * wil);
                    v = memory.getOrDefault(window, 0) - 1;
                    if (v == 0) {
                        memory.remove(window);
                    } else {
                        memory.put(window, v);
                    }
                }
            }
            memory.clear();
        }
        return ans;
    }
}
// @lc code=end

