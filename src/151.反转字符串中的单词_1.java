/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (stack.size() > 0 && !sb.isEmpty()) {
                    sb.append(' ');
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.isEmpty() && !sb.isEmpty()) {
            sb.append(' ');
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
// @lc code=end

