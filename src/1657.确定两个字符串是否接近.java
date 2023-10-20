/*
 * @lc app=leetcode.cn id=1657 lang=java
 *
 * [1657] 确定两个字符串是否接近
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m != n) {
            return false;
        }
        int[] map1 = new int[26], map2 = new int[26];
        for (int i = 0; i < m; i++) {
            map1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            map2[word2.charAt(i) - 'a']++;
        }
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (map1[i] > 0 ^ map2[i] > 0) {
                return false;
            }
            if (map1[i] > 0) {
                countsMap.put(map1[i], countsMap.getOrDefault(map1[i], 0) + 1);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (map2[i] > 0) {
                Integer row = countsMap.remove(map2[i]);
                if (row == null) {
                    return false;
                }
                if (--row > 0) {
                    countsMap.put(map2[i], row);
                }
            }
        }
        return countsMap.isEmpty();
    }
}
// @lc code=end

