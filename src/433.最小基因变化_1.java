/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

import java.util.Set;
import java.util.HashSet;

// @lc code=start
class Solution {
    char[] charsets = new char[] { 'A', 'T', 'C', 'G' };
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }
        if (!set.contains(endGene)) {
            return -1;
        }
        int ans = dfs(startGene, endGene, set, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    int dfs(String startGene, String endGene, Set<String> set, int deepth) {
        if (startGene.equals(endGene)) {
            return deepth;
        }
        int ans = Integer.MAX_VALUE;
        char[] chars = startGene.toCharArray();
        for (int i = 0; i < 8; i++) {
            char oldChar = chars[i];
            for (int j = 0; j < charsets.length; j++) {
                if (oldChar != charsets[j]) {
                    chars[i] = charsets[j];
                    String s = new String(chars);
                    if (set.remove(s)) {
                        ans = Math.min(ans, dfs(s, endGene, set, deepth + 1));
                        set.add(s);
                    }
                }
            }
            chars[i] = oldChar;
        }
        return ans;
    }
}
// @lc code=end

