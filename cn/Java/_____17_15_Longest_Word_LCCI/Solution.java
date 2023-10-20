// @algorithm @lc id=1000022 lang=java 
// @title longest-word-lcci
package _____17_15_Longest_Word_LCCI;
// @test(["cat","banana","dog","nana","walk","walker","dogwalker"])="dogwalker"
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<String, Boolean> memory = new HashMap<>();
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            int diff = a.length() - b.length();
            if (diff == 0) {
                return b.compareTo(a);
            }
            return diff;
        });

        String ans = null;
        memory.put("", true);
        for (int i = 0; i < words.length; i++) {
            if (memory.containsKey(words[i])) {
                continue;
            }
            if (dfs(words[i])) {
                ans = words[i];
            }
            memory.put(words[i], true);
        }
        return ans == null ? "" : ans;
    }
    private boolean dfs(String s) {
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if (memory.getOrDefault(s.substring(0, i), false)
                && dfs(s.substring(i))) {
                memory.put(s, true);
                return true;
            }
        }
        memory.put(s, false);
        return false;
    }
}