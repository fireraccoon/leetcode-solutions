/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, 0, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans, int nums[], int node, int deepth) {
        if (deepth == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; node > 0 && i < nums.length; i++) {
                if (((node >> i) & 0b1) == 1) {
                    list.add(nums[i]);
                }
            }
            ans.add(list);
            return;
        }
        dfs(ans, nums, node, deepth + 1);
        dfs(ans, nums, node | (1 << deepth), deepth + 1);
    }
}
// @lc code=end

