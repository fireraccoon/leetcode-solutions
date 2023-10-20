// @algorithm @lc id=100198 lang=java 
// @title power-set-lcci
package _____08_04_Power_Set_LCCI;
// @test([1,2,3])=[[],[3],[2,3],[2],[1,2],[1,2,3],[1,3],[1]]
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums, 0);
    }
    List<List<Integer>> dfs(int[] nums, int index) {
        if (index == nums.length) {
            return new ArrayList<>(List.of(List.of()));
        }
        List<List<Integer>> ans = dfs(nums, index + 1);
        for (int i = ans.size() - 1; i >= 0; i--) {
            List<Integer> node = new ArrayList<>();
            node.add(nums[index]);
            node.addAll(ans.get(i));
            ans.add(node);
        }
        return ans;
    }
}