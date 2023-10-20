/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] alphas = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                alphas[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                if (alphas[j] != 0) {
                    sb.append((char)j);
                    sb.append(alphas[j]);
                }
            }
            String key = sb.toString();
            List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            hashMap.put(key, list);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }
}
// @lc code=end

