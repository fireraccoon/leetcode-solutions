/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    int ansSize = 0;
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        int leftToRemove = 0, rightToRemove = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftToRemove++;
            } else if (c == ')') {
                if (leftToRemove == 0) {
                    rightToRemove++;
                } else {
                    leftToRemove--;
                }
            }
        }
        dfs(ans, new StringBuilder(s), 0, leftToRemove, rightToRemove);
        return new ArrayList<>(ans);
    }
    void dfs(List<String> ans, StringBuilder sb, int index, int leftToRemove, int rightToRemove) {
        if (leftToRemove == 0 && rightToRemove == 0) {
            if (isValid(sb)) {
                ans.add(sb.toString());
            }
            return;
        }
        int n = sb.length() + Math.min(1 - leftToRemove - rightToRemove, 0);
        for (int i = index; i < n; i++) {
            char c = sb.charAt(i);
            if (i > index && c == sb.charAt(i - 1)) {
                continue;
            }
            if (c == '(' && leftToRemove > 0) {
                dfs(ans, sb.deleteCharAt(i), i, leftToRemove - 1, rightToRemove);
                sb.insert(i, '(');
            } else if (c == ')' && rightToRemove > 0) {
                dfs(ans, sb.deleteCharAt(i), i, leftToRemove, rightToRemove - 1);
                sb.insert(i, ')');
            }
        }
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

