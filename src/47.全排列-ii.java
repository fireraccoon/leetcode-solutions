/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {

    Map<Integer, Integer> duplicates = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            duplicates.put(nums[i], duplicates.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new LinkedList<>(), duplicates.keySet().toArray(new Integer[0]), nums.length);
        return ans;
    }
    void dfs(List<List<Integer>> ans, Deque<Integer> node, Integer[] nums, int maxDeepth) {
        if (node.size() == maxDeepth) {
            ans.add(new ArrayList<>(node));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int duplicate = duplicates.get(nums[i]);
            if (duplicate >= 1) {
                duplicates.put(nums[i], duplicate - 1);
                node.push(nums[i]);
                dfs(ans, node, nums, maxDeepth);
                node.pop();
                duplicates.put(nums[i], duplicate);
            }
        }
    }
}
// @lc code=end

