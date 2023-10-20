/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        List<String> subAns;
        if (digits.length() == 1) {
            subAns = List.of("");
        } else {
            subAns = letterCombinations(digits.substring(1));
        }
        String table = map[digits.charAt(0)-'2'];
        for (int i = 0; i < table.length(); i++) {
            for (String subS: subAns) {
                ans.add(table.substring(i, i + 1) + subS);
            }
        }
        return ans;
    }
}
// @lc code=end

