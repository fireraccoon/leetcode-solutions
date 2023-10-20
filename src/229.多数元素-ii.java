/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int[] votes = new int[2];
        int[] candidates = new int[2];
        for (int i = 0; i < n; i++) {
            if (votes[0] > 0 && candidates[0] == nums[i]) {
                votes[0]++;
            } else if (votes[1] > 0 && candidates[1] == nums[i]) {
                votes[1]++;
            } else if (votes[0] == 0) {
                candidates[0] = nums[i];
                votes[0]++;
            } else if (votes[1] == 0) {
                candidates[1] = nums[i];
                votes[1]++;
            } else {
                votes[0]--;
                votes[1]--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (candidates[0] == nums[i]) {
                c1++;
            } else if (candidates[1] == nums[i]) {
                c2++;
            }
        }
        if (c1 > n / 3) {
            ans.add(candidates[0]);
        }
        if (c2 > n / 3) {
            ans.add(candidates[1]);
        }
        return ans;
    }
}
// @lc code=end

