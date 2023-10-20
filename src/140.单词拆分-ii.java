/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// @lc code=start
class Solution {
    Map<Integer, List<String>> memory;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        memory = new HashMap<>();
        return dfs(0, s, words);
    }
    List<String> dfs(int index, String s, Set<String> words) {
        if (memory.containsKey(index)) {
            return memory.get(index);
        }
        int n = s.length();
        List<String> ans = new LinkedList<>();
        for (int i = index + 1; i <= n; i++) {
            String word = s.substring(index, i);
            if (words.contains(word)) {
                if (i == n) {
                    ans.add(word);
                    break;
                }
                for (String nextWords : dfs(i, s, words)) {
                    ans.add(String.join(" ", word, nextWords));
                }
            }
        }
        if (ans.size() > 0) {
            memory.put(index, ans);
        }
        return ans;
    }
}
// @lc code=end

