/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        return new int[] { iterator.next(), iterator.next() };
    }
}
// @lc code=end

