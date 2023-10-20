// @algorithm @lc id=100242 lang=java 
// @title sparse-array-search-lcci
package _____10_05_Sparse_Array_Search_LCCI_1;
// @test(["at","","","","ball","","","car","","","dad","",""],"ta")=-1
// @test(["at","","","","ball","","","car","","","dad","",""],"ball")=4
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findString(String[] words, String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                map.put(words[i], i);
            }
        }
        return map.getOrDefault(s, -1);
    }
}