/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

import java.util.TreeSet;

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        TreeSet<Long> window = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceil = window.ceiling((long) nums[i] - valueDiff);
            if (ceil != null && ceil <= (long) nums[i] + valueDiff) {
                return true;
            }
            window.add((long) nums[i]);
            if (window.size() > indexDiff) {
                window.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
// @lc code=end

