/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer frequency = map.putIfAbsent(nums[i], 0);
            if (frequency != null) {
                if (frequency.equals(0)) {
                    map.put(nums[i], 1);
                } else {
                    map.remove(nums[i]);
                }
            }
        }
        return map.keySet().iterator().next();
    }
}
// @lc code=end

