/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add(s);
        while (ans.size() == 0) {
            Set<String> next = new HashSet<>();
            for (String string : set) {
                StringBuilder sb = new StringBuilder(string);
                if (isValid(sb)) {
                    ans.add(sb.toString());
                }
                for (int i = 0; ans.size() == 0 && i < sb.length(); i++) {
                    char c = sb.charAt(i);
                    if ((i == 0 || c != sb.charAt(i - 1)) && !Character.isAlphabetic(c)) {
                        next.add(sb.deleteCharAt(i).toString());
                        sb.insert(i, c);
                    }
                }
            }
            set = next;
        }
        return ans;
    }
    boolean isValid(StringBuilder sb) {
        int leftCount = 0, n = sb.length();
        for (int i = 0; i < n; i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                leftCount++;
            } else if (c == ')' && --leftCount < 0) {
                return false;
            }
        }
        return leftCount == 0;
    }
}
// @lc code=end

