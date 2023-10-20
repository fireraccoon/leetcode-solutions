// @algorithm @lc id=1000039 lang=java 
// @title find-closest-lcci
package _____17_11_Find_Closest_LCCI;
import java.util.ArrayList;
// @test(["I","am","a","student","from","a","university","in","a","city"],"a","student")=1
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> indices = map.get(words[i]);
            if (indices == null) {
                indices = new ArrayList<>();
                map.put(words[i], indices);
            }
            indices.add(i);
        }

        List<Integer> indices1 = map.get(word1);
        List<Integer> indices2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < indices1.size() && j < indices2.size()) {
            int diff = indices1.get(i) - indices2.get(j);
            if (diff > 0) {
                j++;
                ans = Math.min(ans, diff);
            } else {
                i++;
                ans = Math.min(ans, -diff);
            }
        }
        return ans;
    }
}