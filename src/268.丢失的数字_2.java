/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        set.remove(nums.length);
        return set.isEmpty() ? nums.length : set.iterator().next();
    }
}
// @lc code=end

