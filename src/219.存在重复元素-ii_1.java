/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = map.put(nums[i], i);
            if (lastIndex != null && i - lastIndex <= k) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

