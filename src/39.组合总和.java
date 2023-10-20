/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

import java.util.List;
import java.util.ArrayList;

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
    void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> node, int pointer) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(node));
            return;
        }
        for (int i = pointer; i < candidates.length; i++) {
            node.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, node, i);
            node.remove(node.size() - 1);
        }
    }
}
// @lc code=end

