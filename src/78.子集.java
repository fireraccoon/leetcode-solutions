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
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}
// @lc code=end

