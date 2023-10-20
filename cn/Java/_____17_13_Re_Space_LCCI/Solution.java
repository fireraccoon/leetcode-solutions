// @algorithm @lc id=1000020 lang=java 
// @title re-space-lcci
package _____17_13_Re_Space_LCCI;
// @test(["looked","just","like","her","brother"],"jesslookedjustliketimherbrother")=7
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (int i = 0; i < dictionary.length; i++) {
            trie.add(dictionary[i]);
        }

        int n = sentence.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            Trie node = trie;
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                node = node.children[sentence.charAt(j) - 'a'];
                if (node == null) {
                    break;
                }
                if (node.exist) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + i - j);
                }
            }
        }
        return dp[n];
    }
    private class Trie {
        private boolean exist = false;
        private Trie[] children = new Trie[26];
        public void add(String s) {
            Trie trie = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int node = s.charAt(i) - 'a';
                if (trie.children[node] == null) {
                    trie.children[node] = new Trie();
                }
                trie = trie.children[node];
            }
            trie.exist = true;
        }
    }
}