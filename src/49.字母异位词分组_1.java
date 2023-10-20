/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String s = new String(str);
            List<String> list = hashMap.getOrDefault(s, new ArrayList<>());
            list.add(strs[i]);
            hashMap.put(s, list);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }
}
// @lc code=end

