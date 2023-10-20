// @algorithm @lc id=1000042 lang=java 
// @title pairs-with-sum-lcci
package _____16_24_Pairs_With_Sum_LCCI;
// @test([5,6,5],11)=[[6,5]]
// @test([5,6,5,6],11)=[[6,5],[6,5]]
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int frequency = frequencies.getOrDefault(nums[i], 0);
            if (frequency > 0) {
                ans.add(List.of(nums[i], target - nums[i]));
                frequencies.put(nums[i], frequency - 1);
            } else {
                frequencies.merge(target - nums[i], 1, Integer::sum);
            }
        }
        return ans;
    }
}