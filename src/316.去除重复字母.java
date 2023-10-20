/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<>();
        boolean[] added = new boolean[26];
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            counts[c - 'a']--;
            if (!added[c - 'a']) {
                while (!stack.isEmpty() && counts[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                    added[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                added[c - 'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

