/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new LinkedList<>(), nums);
        return ans;
    }
    void dfs(List<List<Integer>> ans, Deque<Integer> node, int[] nums) {
        if (node.size() == nums.length) {
            ans.add(new ArrayList<>(node));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!node.contains(nums[i])) {
                node.push(nums[i]);
                dfs(ans, node, nums);
                node.pop();
            }
        }
    }
}
// @lc code=end

