// @algorithm @lc id=1000024 lang=java
// @title multi-search-lcci
package _____17_17_Multi_Search_LCCI;
// @test("mississippi",["is","ppi","hi","sis","i","ssippi"])=[[1,4],[8],[],[3],[1,4,7,10],[5]]
import java.util.ArrayList;
import java.util.List;

public class Solution {
    @SuppressWarnings("unchecked")
    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie();
        List<Integer>[] ans = new List[smalls.length];
        for (int i = 0; i < smalls.length; i++) {
            trie.add(smalls[i], i);
            ans[i] = new ArrayList<>();
        }

        int n = big.length();
        for (int i = 0; i < n; i++) {
            Trie node = trie;
            for (int j = i; j < n; j++) {
                node = node.children[big.charAt(j) - 'a'];
                if (node == null) {
                    break;
                }
                if (node.index != -1) {
                    ans[node.index].add(i);
                }
            }
        }
        return toArray(ans);
    }
    private int[][] toArray(List<Integer>[] ans) {
        int[][] array = new int[ans.length][];
        for (int i = 0; i < ans.length; i++) {
            array[i] = ans[i].stream().mapToInt(Integer::valueOf).toArray();
        }
        return array;
    }
    private class Trie {
        private int index = -1;
        private Trie[] children = new Trie[26];
        private void add(String s, int index) {
            Trie trie = this;
            for (int i = 0; i < s.length(); i++) {
                int node = s.charAt(i) - 'a';
                if (trie.children[node] == null) {
                    trie.children[node] = new Trie();
                }
                trie = trie.children[node];
            }
            trie.index = index;
        }
    }
}