/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int targetFrequency = n / 3 + 1;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n && ans.size() < 2; i++) {
            int frequency = map.getOrDefault(nums[i], 0) + 1;
            if (frequency == targetFrequency) {
                ans.add(nums[i]);
            }
            map.put(nums[i], frequency);
        }
        return ans;
    }
}
// @lc code=end

