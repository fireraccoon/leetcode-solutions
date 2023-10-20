/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    int minDistance = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new LinkedList<>(){{
            add(beginWord);
        }}, new boolean[wordList.size()], new int[wordList.size()], endWord, wordList);
        return ans;
    }
    void dfs(List<List<String>> ans, Deque<String> node, boolean[] used, int[] distance, String endWord, List<String> wordList) {
        if (node.peekLast().equals(endWord)) {
            if (minDistance > node.size()) {
                minDistance = node.size();
                ans.clear();
            }
            if (minDistance == node.size()) {
                ans.add(new ArrayList<>(node));
            }
            return;
        }
        if (minDistance <= node.size()) {
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && (distance[i] == 0 || distance[i] >= node.size())) {
                if (isNear(node.peekLast(), wordList.get(i))) {
                    distance[i] = node.size();
                    used[i] = true;
                    node.offerLast(wordList.get(i));
                    dfs(ans, node, used, distance, endWord, wordList);
                    used[i] = false;
                    node.pollLast();
                }
            }
        }
    }
    boolean isNear(String a, String b) {
        int i = 0;
        boolean ans = false;
        for (; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ans = true;
                break;
            }
        }
        for (i++; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return ans;
    }
}
// @lc code=end

