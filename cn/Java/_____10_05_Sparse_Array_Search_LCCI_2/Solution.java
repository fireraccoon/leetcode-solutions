// @algorithm @lc id=100242 lang=java 
// @title sparse-array-search-lcci
package _____10_05_Sparse_Array_Search_LCCI_2;
// @test(["at","","","","ball","","","car","","","dad","",""],"ta")=-1
// @test(["at","","","","ball","","","car","","","dad","",""],"ball")=4
// @test(["DirNnILhARNS hOYIFB","SM ","YSPBaovrZBS","evMMBOf","mCrS","oRJfjw gwuo","xOpSEXvfI"],"mCrS")=4
public class Solution {
    public int findString(String[] words, String s) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            if (!s.isEmpty()) {
                trie.add(words[i], i);
            }
        }
        return trie.search(s);
    }
    private class Trie {

        private int index = -1;

        private Trie[] children = new Trie[126];

        public void add(String s, int index) {
            int n = s.length();
            Trie trie = this;
            for (int i = 0; i < n; i++) {
                int node = s.charAt(i);
                if (trie.children[node] == null) {
                    trie.children[node] = new Trie();
                }
                trie = trie.children[node];
            }
            trie.index = index;
        }

        public int search(String s) {
            Trie trie = prefixSearch(s);
            return trie == null ? -1 : trie.index;
        }

        public Trie prefixSearch(String s) {
            int n = s.length();
            Trie trie = this;
            for (int i = 0; i < n && trie != null; i++) {
                trie = trie.children[s.charAt(i)];
            }
            return trie;
        }
    }
}