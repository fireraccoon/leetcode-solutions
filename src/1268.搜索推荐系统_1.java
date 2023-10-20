/*
 * @lc app=leetcode.cn id=1268 lang=java
 *
 * [1268] 搜索推荐系统
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {

    private final static int LIMIT = 3;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        Arrays.sort(products);
        for (int i = 0; i < products.length; i++) {
            trie.add(products[i]);
        }

        int n = searchWord.length();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = searchWord.charAt(i);
            sb.append(c);
            trie = trie.prefixSearch(Character.toString(c));
            if (trie == null) {
                break;
            }
            trie.suggest(ans.get(i), sb, LIMIT);
        }
        return ans;
    }

    private class Trie {

        private List<Integer> indices = new ArrayList<>();

        private boolean exist = false;

        private Trie[] children = new Trie[26];

        public boolean add(String s) {
            int n = s.length();
            Trie pointer = this;
            for (int i = 0; i < n; i++) {
                int childIndex = s.charAt(i) - 'a';
                if (pointer.children[childIndex] == null) {
                    pointer.indices.add(childIndex);
                    pointer.children[childIndex] = new Trie();
                }
                pointer = pointer.children[childIndex];
            }
            if (pointer.exist) {
                return false;
            }
            pointer.exist = true;
            return true;
        }

        public Trie prefixSearch(String s) {
            int n = s.length();
            Trie pointer = this;
            for (int i = 0; i < n && pointer != null; i++) {
                pointer = pointer.children[s.charAt(i) - 'a'];
            }
            return pointer;
        }

        public void suggest(List<String> ans, StringBuilder node, int limit) {
            if (exist) {
                ans.add(node.toString());
            }
            for (int i = 0; i < indices.size() && ans.size() < limit; i++) {
                int index = indices.get(i);
                if (children[index] != null) {
                    node.append((char) (index + 'a'));
                    children[index].suggest(ans, node, limit);
                    node.deleteCharAt(node.length() - 1);
                }
            }
        }
    }
}
// @lc code=end

