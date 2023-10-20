/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    int[] memory;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        memory = new int[s.length()];
        return dfs(s, 0, words);
    }
    boolean dfs(String s, int index, Set<String> words) {
        if (index == s.length()) {
            return true;
        }
        if (memory[index] != 0) {
            return memory[index] == 1;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (words.contains(s.substring(index, i)) && dfs(s, i, words)) {
                memory[index] = 1;
                return true;
            }
        }
        memory[index] = -1;
        return false;
    }
}
// @lc code=end

