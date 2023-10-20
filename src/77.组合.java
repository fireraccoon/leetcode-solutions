/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, n, k);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> node, int pointer, int n, int k) {
        if (node.size() == k) {
            ans.add(new ArrayList<>(node));
            return;
        }
        for (int i = pointer + 1; i <= n + node.size() + 1 - k; i++) {
            node.add(i);
            dfs(ans, node, i, n, k);
            node.remove(node.size() - 1);
        }
    }
}
// @lc code=end

