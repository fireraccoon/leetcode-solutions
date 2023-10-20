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
    int ansSize = 0;
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        dfs(ans, new StringBuilder(), 0, s, 0);
        return new ArrayList<>(ans);
    }
    void dfs(Set<String> ans, StringBuilder sb, int leftCount, String s, int index) {
        int stringLength = sb.length();
        if (leftCount == 0 && stringLength >= ansSize) {
            if (stringLength > ansSize) {
                ans.clear();
                ansSize = stringLength;
            }
            ans.add(sb.toString());
        }
        if (index == s.length()) {
            return;
        }
        char c = s.charAt(index);
        index++;
        if (Character.isAlphabetic(c)) {
            dfs(ans, sb.append(c), leftCount, s, index);
            sb.deleteCharAt(stringLength);
        } else if (c == '(') {
            dfs(ans, sb.append(c), leftCount + 1, s, index);
            dfs(ans, sb.deleteCharAt(stringLength), leftCount, s, index);
        } else if (leftCount > 0) {
            dfs(ans, sb.append(c), leftCount - 1, s, index);
            dfs(ans, sb.deleteCharAt(stringLength), leftCount, s, index);
        } else {
            dfs(ans, sb, 0, s, index);
        }
    }
}
// @lc code=end

