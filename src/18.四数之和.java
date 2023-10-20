/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) {
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                Long twoTarget = (long)target - nums[i] - nums[j];
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                for (int k = j + 1, l = n - 1; k < l;) {
                    if (k > j + 1 && nums[k] == nums[k-1]) {
                        k++;
                        continue;
                    } else if (l < n - 1 && nums[l] == nums[l+1]) {
                        l--;
                        continue;
                    }
                    long sum = nums[k] + nums[l];
                    if (sum == twoTarget) {
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (sum < twoTarget) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

