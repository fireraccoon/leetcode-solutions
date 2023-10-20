/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.add(nums[i])) {
                hash.remove(nums[i]);
            }
        }
        return hash.iterator().next();
    }
}
// @lc code=end

