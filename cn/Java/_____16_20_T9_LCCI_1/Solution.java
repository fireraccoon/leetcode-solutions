// @algorithm @lc id=1000047 lang=java 
// @title t9-lcci
package _____16_20_T9_LCCI_1;
// @test("8733",["tree","used"])=["tree","used"]
// @test("2",["a","b","c","d"])=["a","b","c"]
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private char[][] t9_map = new char[][] {
        { '_' }, { '!', '@', '#' }, { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
        { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
        { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }
    };
    public List<String> getValidT9Words(String num, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.add(words[i]);
        }
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), trie, num.toCharArray(), 0);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder path, Trie trie, char[] num, int depth) {
        if (depth == num.length) {
            if (trie.exist) {
                ans.add(path.toString());
            }
            return;
        }
        if (trie.size == 0) {
            return;
        }

        char[] chars = t9_map[num[depth] - '0'];
        ++depth;
        for (int i = 0; i < chars.length; i++) {
            Trie node = trie.children[chars[i] - 'a'];
            if (node != null) {
                path.append(chars[i]);
                dfs(ans, path, node, num, depth);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    private class Trie {
        private int size = 0;
        private boolean exist = false;
        private Trie[] children = new Trie[26];
        public boolean add(String s) {
            Trie trie = this;
            for (int i = 0; i < s.length(); i++) {
                int node = s.charAt(i) - 'a';
                if (trie.children[node] == null) {
                    trie.children[node] = new Trie();
                    trie.size++;
                }
                trie = trie.children[node];
            }
            return trie.exist ? false : (trie.exist = true);
        }
    }
}