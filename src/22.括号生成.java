/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb  = new StringBuilder();
        backtrack(ans, sb, 0, 0, n);
        return ans;
    }
    void backtrack(List<String> ans, StringBuilder sb, int numsBegin, int numsEnd, int deepth) {
        if (sb.length() == deepth * 2) {
            ans.add(sb.toString());
            return;
        }
        if (numsBegin < deepth) {
            sb.append("(");
            backtrack(ans, sb, numsBegin + 1, numsEnd, deepth);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (numsBegin > numsEnd) {
            sb.append(")");
            backtrack(ans, sb, numsBegin, numsEnd + 1, deepth);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
// @lc code=end

