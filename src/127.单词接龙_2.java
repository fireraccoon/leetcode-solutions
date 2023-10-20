/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int deepth = 1, n = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String word = queue.poll();
                for (int j = 0; j < n; j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (word.equals(endWord)) {
                            return deepth;
                        }
                        if (words.contains(nextWord)) {
                            queue.offer(nextWord);
                            words.remove(nextWord);
                        }
                    }
                }
            }
            deepth++;
        }
        return 0;
    }
}
// @lc code=end

