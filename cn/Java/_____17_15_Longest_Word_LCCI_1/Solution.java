// @algorithm @lc id=1000022 lang=java 
// @title longest-word-lcci
package _____17_15_Longest_Word_LCCI_1;
// @test(["cat","banana","dog","nana","walk","walker","dogwalker"])="dogwalker"
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Solution {
    private Set<Integer> set = new HashSet<>();
    public String longestWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            set.add(getHash(words[i]));
        }

        String ans = null;
        for (int i = 0; i < words.length; i++) {
            if (dfs(words[i], 0, 0)) {
                ans = longestString(ans, words[i]);
            }
        }
        return ans == null ? "" : ans;
    }
    private boolean dfs(String s, int lastIndex, int index) {
        if (index == s.length()) {
            return lastIndex != 0;
        }
        int hash = 1;
        for (int i = index; i < s.length(); i++) {
            hash = getHash(hash, s.charAt(i));
            if (set.contains(hash)) {
                if (dfs(s, index, i + 1) ) {
                    return true;
                }
            }
        }
        return false;
    }
    private String longestString(String a, String b) {
        if (a == null) {
            return b;
        }
        int diff = a.length() - b.length();
        if (diff == 0) {
            return a.compareTo(b) < 0 ? a : b;
        }
        return diff > 0 ? a : b;
    }
    private int getHash(String s) {
        int hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash = getHash(hash, s.charAt(i));
        }
        return hash;
    }
    private int getHash(int hash, char c) {
        return Objects.hash(hash, c);
    }
}