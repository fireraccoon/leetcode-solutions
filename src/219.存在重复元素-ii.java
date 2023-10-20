/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!window.add(nums[i])) {
                return true;
            }
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
// @lc code=end

