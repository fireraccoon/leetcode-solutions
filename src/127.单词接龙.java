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
        int n = beginWord.length();
        Set<String> queue1 = new HashSet<>();
        Set<String> queue2 = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.remove(endWord)) {
            return 0;
        }
        words.remove(beginWord);
        queue1.add(beginWord);
        queue2.add(endWord);
        for (int deepth = 2; !queue1.isEmpty() && !queue2.isEmpty(); deepth++) {
            Set<String> added = new HashSet<>();
            for (String word : queue1) {
                for (int i = 0; i < n; i++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if (queue2.contains(nextWord)) {
                            return deepth;
                        }
                        if (words.contains(nextWord)) {
                            added.add(nextWord);
                            words.remove(nextWord);
                        }
                    }
                }
            }
            if (added.size() > queue2.size()) {
                queue1 = queue2;
                queue2 = added;
            } else {
                queue1 = added;
            }
        }
        return 0;
    }
}
// @lc code=end

