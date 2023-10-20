/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

import java.util.Random;

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        Random random = new Random();
        for (int count = 0; count <= n / 2;) {
            count = 0;
            ans = nums[random.nextInt(n)];
            for (int i = 0; i < n; i++) {
                if (nums[i] == ans) {
                    count++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

