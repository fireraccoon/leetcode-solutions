/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, new ArrayList<>(), 0, 0, nums);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> node, int pointer, int deepth, int[] nums) {
        if (deepth == nums.length) {
            ans.add(new ArrayList<>(node));
            return;
        }
        if (node.size() == 0 || nums[pointer] != node.get(node.size() - 1)) {
            dfs(ans, node, pointer + 1, deepth + 1, nums);
        }
        node.add(nums[pointer]);
        dfs(ans, node, pointer + 1, deepth + 1, nums);
        node.remove(node.size() - 1);
    }
}
// @lc code=end

