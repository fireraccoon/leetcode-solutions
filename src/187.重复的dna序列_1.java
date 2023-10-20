/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= n - 10; i++) {
            String key = s.substring(i, i + 10);
            if (!set.add(key)) {
                ans.add(key);
            }
        }
        return new ArrayList<>(ans);
    }
}
// @lc code=end

