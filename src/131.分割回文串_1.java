/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    int[][] memory;
    public List<List<String>> partition(String s) {
        int n = s.length();
        memory = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new LinkedList<>(), 0, s);
        return ans;
    }
    void dfs(List<List<String>> ans, Deque<String> node, int pointer, String s) {
        if (pointer >= memory.length) {
            ans.add(new ArrayList<>(node));
            return;
        }
        for (int i = pointer; i < memory.length; i++) {
            if (isPalindrome(s, pointer, i - pointer)) {
                node.offerLast(s.substring(pointer, i + 1));
                dfs(ans, node, i + 1, s);
                node.pollLast();
            }
        }
    }
    boolean isPalindrome(String s, int index, int length) {
        if (memory[index][length] != 0) {
            return memory[index][length] == 1;
        }
        boolean ans = length == 0 || (
            s.charAt(index) == s.charAt(index + length)
            && (length == 1 || isPalindrome(s, index + 1, length - 2)));
        memory[index][length] = ans ? 1 : -1;
        return ans;
    }
}
// @lc code=end

