/*
 * @lc app=leetcode.cn id=1679 lang=java
 *
 * [1679] K 和数对的最大数目
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int frequency = map.getOrDefault(nums[i], 0);
            if (frequency > 0) {
                ans++;
                map.put(nums[i], --frequency);
            } else {
                Integer key = k - nums[i];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return ans;
    }
}
// @lc code=end

