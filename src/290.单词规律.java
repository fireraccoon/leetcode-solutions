/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        int m = pattern.length();
        int n = s.length();
        Map<String, Character> wordsMap = new HashMap<>();
        Map<Character, String> charsMap = new HashMap<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            StringBuilder sb = new StringBuilder();
            for (sb.append(s.charAt(i)); ++i < n && s.charAt(i) != ' '; sb.append(s.charAt(i)));
            Character c = pattern.charAt(j);
            String word = sb.toString();
            Character bindC = wordsMap.put(word, c);
            String bindWord = charsMap.put(c, word);
            if (bindC != null && !c.equals(bindC) || bindWord != null && !word.equals(bindWord)) {
                return false;
            }
            i++;
            j++;
        }
        return i >= n && j >= m;
    }
}
// @lc code=end

