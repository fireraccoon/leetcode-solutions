/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > pointer && candidates[i] == candidates[i-1]) {
                continue;
            }
            node.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, node, i + 1);
            node.remove(node.size() - 1);
        }
    }
}
// @lc code=end

