// @algorithm @lc id=1000049 lang=java 
// @title word-rectangle-lcci
package _____17_25_Word_Rectangle_LCCI;
// @test(["this","real","hard","trh","hea","iar","sld"])=["this","real","hard"]
// @test(["aa"])=["aa","aa"]
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    private int maxArea = 0, maxWordLength = 0;
    private List<String> ans = List.of();
    public String[] maxRectangle(String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.add(words[i]);
        }

        Map<Integer, List<String>> wordsMap = groupByLength(words);
        for (int len = maxWordLength; len > 0 && maxArea == 0; len--) {
            List<String> wordsGroup = wordsMap.get(len);
            if (wordsGroup != null) {
                dfs(new LinkedList<>(), false, wordsGroup,
                    getTries(trie, len), 0);
            }
        }
        return ans.toArray(new String[0]);
    }
    private void dfs(LinkedList<String> path, boolean available, List<String> words, Trie[] tries, int rowCounts) {
        if (available && rowCounts * tries.length > maxArea) {
            ans = new LinkedList<>(path);
            maxArea = rowCounts * tries.length;
        }

        dfs_outter: for (String word : words) {
            available = true;
            Trie[] nexts = new Trie[tries.length];
            for (int i = 0; i < tries.length; i++) {
                nexts[i] = tries[i].children[word.charAt(i) - 'a'];
                if (nexts[i] == null) {
                    continue dfs_outter;
                }
                available &= nexts[i].exist;
            }
            path.addLast(word);
            dfs(path, available, words, nexts, rowCounts + 1);
            path.removeLast();
        }
    }
    private Trie[] getTries(Trie trie, int n) {
        Trie[] tries = new Trie[n];
        for (int i = 0; i < n; i++) {
            tries[i] = trie;
        }
        return tries;
    }
    private Map<Integer, List<String>> groupByLength(String[] words) {
        Map<Integer, List<String>> wordsGroup = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            List<String> group = wordsGroup.get(length);
            if (group == null) {
                group = new ArrayList<>();
                wordsGroup.put(length, group);
                maxWordLength = Math.max(maxWordLength, length);
            }
            group.add(words[i]);
        }
        return wordsGroup;
    }
    private class Trie {
        private Trie[] children = new Trie[26];
        private boolean exist = false;
        public void add(String s) {
            Trie trie = this;
            for (int i = 0; i < s.length(); i++) {
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