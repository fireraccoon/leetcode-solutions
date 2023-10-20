/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> middleNodes = new HashSet<>();
        Map<String, Set<String>> preMap = new HashMap<>();
        Map<String, Set<String>> nextMap = new HashMap<>();
        if (!bfs(preMap, nextMap, middleNodes, beginWord, endWord, wordList)) {
            return ans;
        }
        List<List<String>> subAns = new ArrayList<>();
        for (String word : middleNodes) {
            dfs(subAns, new LinkedList<>() {{
                add(word);
            }}, preMap, true);
        }
        for (List<String> subList : subAns) {
            dfs(ans, new LinkedList<>(subList), nextMap, false);
        }
        return ans;
    }
    boolean bfs(Map<String, Set<String>> preMap, Map<String, Set<String>> nextMap, Set<String> middleNodes, String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        Set<String> words = new HashSet<>(wordList);
        Set<String> queueStart = new HashSet<>();
        Set<String> queueEnd = new HashSet<>();
        if (!words.remove(endWord)) {
            return false;
        }
        words.remove(beginWord);
        queueStart.add(beginWord);
        queueEnd.add(endWord);
        while (!queueStart.isEmpty() && middleNodes.size() == 0) {
            Set<String> added = new HashSet<>();
            for (String word : queueStart) {
                for (int i = 0; i < n; i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if (queueEnd.contains(nextWord)) {
                            middleNodes.add(nextWord);
                            preMap.putIfAbsent(nextWord, new HashSet<>());
                            preMap.get(nextWord).add(word);
                        }
                        if (words.contains(nextWord)) {
                            added.add(nextWord);
                            preMap.putIfAbsent(nextWord, new HashSet<>());
                            preMap.get(nextWord).add(word);
                        }
                    }
                }
            }
            if (middleNodes.size() > 0) {
                break;
            }
            queueStart = added;
            words.removeAll(added);

            added = new HashSet<>();
            for (String word : queueEnd) {
                for (int i = 0; i < n; i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if (queueStart.contains(nextWord)) {
                            middleNodes.add(nextWord);
                            nextMap.putIfAbsent(nextWord, new HashSet<>());
                            nextMap.get(nextWord).add(word);
                        }
                        if (words.contains(nextWord)) {
                            added.add(nextWord);
                            nextMap.putIfAbsent(nextWord, new HashSet<>());
                            nextMap.get(nextWord).add(word);
                        }
                    }
                }
            }
            queueEnd = added;
            words.removeAll(added);
        }
        return middleNodes.size() > 0;
    }
    void dfs(List<List<String>> ans, Deque<String> path, Map<String, Set<String>> map, boolean reverse) {
        String word = reverse ? path.peekFirst() : path.peekLast();
        if (!map.containsKey(word)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (String nextWord: map.get(word)) {
            if (reverse) {
                path.offerFirst(nextWord);
                dfs(ans, path, map, reverse);
                path.pollFirst();
            } else {
                path.offerLast(nextWord);
                dfs(ans, path, map, reverse);
                path.pollLast();
            }
        }
    }
}
// @lc code=end

