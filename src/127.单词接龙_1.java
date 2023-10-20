/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int deepth = 1, n = beginWord.length();
        Set<String> queueStart = new HashSet<>();
        Set<String> queueEnd = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.remove(endWord)) {
            return 0;
        }
        words.remove(beginWord);
        queueStart.add(beginWord);
        queueEnd.add(endWord);
        while (!queueStart.isEmpty()) {
            deepth++;
            Set<String> added = new HashSet<>();
            for (String word : queueStart) {
                for (int i = 0; i < n; i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if (queueEnd.contains(nextWord)) {
                            return deepth;
                        }
                        if (words.contains(nextWord)) {
                            added.add(nextWord);
                            words.remove(nextWord);
                        }
                    }
                }
            }
            queueStart = added;

            deepth++;
            added = new HashSet<>();
            for (String word : queueEnd) {
                for (int i = 0; i < n; i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if (queueStart.contains(nextWord)) {
                            return deepth;
                        }
                        if (words.contains(nextWord)) {
                            added.add(nextWord);
                            words.remove(nextWord);
                        }
                    }
                }
            }
            queueEnd = added;
        }
        return 0;
    }
}
// @lc code=end

