/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

import java.util.List;
import java.util.ArrayList;

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < (1 << 9); mask++) {
            List<Integer> nums = getAns(mask, k, n);
            if (nums != null) {
                ans.add(nums);
            }
        }
        return ans;
    }
    List<Integer> getAns(int mask, int k, int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if ((mask >> i & 1) == 1) {
                nums.add(i + 1);
            }
        }
        if (nums.size() != k) {
            return null;
        }
        for (int i : nums) {
            n -= i;
        }
        return n == 0 ? nums : null;
    }
}
// @lc code=end

