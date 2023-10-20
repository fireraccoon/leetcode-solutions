// @algorithm @lc id=1000051 lang=java 
// @title sparse-similarity-lcci
package _____17_26_Sparse_Similarity_LCCI;
// @test([[14,15,100,9,3],[32,1,9,3,5],[15,29,2,6,8,7],[7,10]])=["2,3: 0.1429","0,1: 0.2500","0,2: 0.1000"]
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    private final static String[] ZEROS_PADDING = new String[] { "", "0", "00", "000" };

    public List<String> computeSimilarities(int[][] docs) {
        Map<Integer, Integer> intersections = getAvailablePairs(docs);
        List<String> ans = new ArrayList<>();
        for (Entry<Integer, Integer> entry : intersections.entrySet()) {
            int pair = entry.getKey();
            int i = pair >>> 16, j = pair & 0xffff;
            int intersection = entry.getValue();
            int union = docs[i].length + docs[j].length - intersection;
            double similarity = calculateSimilarity(union, intersection);
            ans.add(getSimilarityInfo(i, j, similarity));
        }
        return ans;
    }

    private Map<Integer, Integer> getAvailablePairs(int[][] docs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                List<Integer> indices = map.get(docs[i][j]);
                if (indices == null) {
                    indices = new ArrayList<>();
                    map.put(docs[i][j], indices);
                }
                indices.add(i);
            }
        }

        Map<Integer, Integer> intersections = new HashMap<>();
        for (List<Integer> indices : map.values()) {
            for (int i = indices.size() - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    intersections.merge(indices.get(i) | indices.get(j) << 16, 1, Integer::sum);
                }
            }
        }
        return intersections;
    }

    private double calculateSimilarity(int union, int intersection) {
        return Math.round(intersection * 10000D / union) / 10000D;
    }

    private String getSimilarityInfo(int i, int j, double similarity) {
        String value = Double.toString(similarity);
        return new StringBuilder().append(i).append(',').append(j).append(": ")
            .append(value).append(ZEROS_PADDING[6 - value.length()]).toString();
    }
}