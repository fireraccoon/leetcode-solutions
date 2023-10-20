/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0, n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i] - 1)) {
                if (set.contains(nums[i] + ans)) {
                    int length = 1;
                    while (set.contains(nums[i] + length)) {
                        length++;
                    }
                    ans = Math.max(ans, length);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

