// @algorithm @lc id=1000039 lang=java 
// @title find-closest-lcci
package _____17_11_Find_Closest_LCCI_1;
// @test(["I","am","a","student","from","a","university","in","a","city"],"a","student")=1
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int word1Index = -1, word2Index = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                word1Index = i;
            } else if (word2.equals(words[i])) {
                word2Index = i;
            }
            if (word1Index != -1 && word2Index != -1) {
                ans = Math.min(ans, Math.abs(word1Index - word2Index));
            }
        }
        return ans;
    }
}