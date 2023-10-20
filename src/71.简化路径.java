/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        int endOfBasename = path.length(), parentsDeepth = 0;
        boolean isSep = true;
        for (int i = endOfBasename - 1; i >= 0; i--) {
            if (path.charAt(i) == '/') {
                if (!isSep && ((endOfBasename != i + 2) || path.charAt(i + 1) != '.')) {
                    String basename = path.substring(i + 1, endOfBasename);
                    if (basename.equals("..")) {
                        parentsDeepth++;
                    } else if (parentsDeepth > 0) {
                        parentsDeepth--;
                    } else {
                        stack.push(basename);
                    }
                }
                isSep = true;
                endOfBasename = i;
            } else {
                isSep = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append('/');
            sb.append(stack.pop());
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
// @lc code=end

