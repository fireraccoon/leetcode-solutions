// @algorithm @lc id=1000040 lang=java 
// @title group-anagrams-lcci
package _____10_02_Group_Anagrams_LCCI;
// @test(["eat","tea","tan","ate","nat","bat"])=[["eat","tea","ate"],["bat"],["tan","nat"]]
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String hash = getHash(strs[i]);
            List<String> anagrams = map.putIfAbsent(hash, new ArrayList<>());
            if (anagrams == null) {
                map.get(hash).add(strs[i]);
            } else {
                anagrams.add(strs[i]);
            }
        }
        return List.copyOf(map.values());
    }
    String getHash(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}