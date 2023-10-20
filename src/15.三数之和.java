/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

 // @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1, k = n - 1; k > j;) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                } else if (k < n - 1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

