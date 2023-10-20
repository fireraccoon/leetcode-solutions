/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int targetLength = (nums.length + 1) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int frequency = map.getOrDefault(nums[i], 0);
            frequency++;
            if (frequency == targetLength) {
                return nums[i];
            }
            map.put(nums[i], frequency);
        }
        return 0;
    }
}
// @lc code=end

