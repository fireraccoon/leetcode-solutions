/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Set<String>> preMap = new HashMap<>();
        if (!bfs(preMap, beginWord, endWord, wordList)) {
            return ans;
        }
        dfs(ans, new LinkedList<>(), preMap, endWord);
        return ans;
    }
    boolean bfs(Map<String, Set<String>> preMap, String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        boolean founded = false;
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.remove(endWord)) {
            return false;
        }
        words.remove(beginWord);
        queue.add(beginWord);
        while (!queue.isEmpty() && !founded) {
            Set<String> added = new HashSet<>();
            for (int i = queue.size(); i > 0; i--) {
                String word = queue.poll();
                for (int j = 0; j < n; j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (nextWord.equals(endWord)) {
                            preMap.putIfAbsent(nextWord, new HashSet<>());
                            preMap.get(nextWord).add(word);
                            founded = true;
                        }
                        if (words.contains(nextWord)) {
                            queue.offer(nextWord);
                            added.add(nextWord);
                            preMap.putIfAbsent(nextWord, new HashSet<>());
                            preMap.get(nextWord).add(word);
                        }
                    }
                }
            }
            words.removeAll(added);
        }
        return founded;
    }
    void dfs(List<List<String>> ans, Deque<String> path, Map<String, Set<String>> preMap, String word) {
        path.push(word);
        if (!preMap.containsKey(word)) {
            ans.add(new ArrayList<>(path));
        } else {
            for (String preWord : preMap.get(word)) {
                dfs(ans, path, preMap, preWord);
            }
        }
        path.pop();
    }
}
// @lc code=end

