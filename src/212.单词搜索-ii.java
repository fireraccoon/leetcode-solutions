/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        trie.add(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(ans, words, trie, board, i, j);
            }
        }
        return ans;
    }
    void dfs(List<String> ans, String[] words, Trie parent, char[][] board, int i, int j) {
        Trie trie = parent.children[board[i][j] - 'a'];
        if (trie == null) {
            return;
        }
        if (trie.index != -1) {
            ans.add(words[trie.index]);
            trie.index = -1;
        }
        board[i][j] ^= 0x100;
        if (i > 0 && board[i - 1][j] >> 8 == 0) {
            dfs(ans, words, trie, board, i - 1, j);
        }
        if (j > 0 && board[i][j - 1] >> 8 == 0) {
            dfs(ans, words, trie, board, i, j - 1);
        }
        if (i < board.length - 1 && board[i + 1][j] >> 8 == 0) {
            dfs(ans, words, trie, board, i + 1, j);
        }
        if (j < board[0].length - 1 && board[i][j + 1] >> 8 == 0) {
            dfs(ans, words, trie, board, i, j + 1);
        }
        board[i][j] ^= 0x100;
        if (trie.childrenCount <= 0) {
            parent.childrenCount--;
            parent.children[board[i][j] - 'a'] = null;
        }
    }
    private class Trie {
        private int index = -1;
        private Trie[] children = new Trie[26];
        private int childrenCount = 0;
        private void add(String word, int index) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (node.children[c] == null) {
                    node.children[c] = new Trie();
                    node.childrenCount++;
                }
                node = node.children[c];
            }
            node.index = index;
        }
        public void add(String[] words) {
            for (int i = 0; i < words.length; i++) {
                add(words[i], i);
            }
        }
    }
}
// @lc code=end

