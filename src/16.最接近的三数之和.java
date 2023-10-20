/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0, distance = Integer.MAX_VALUE, kn = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = kn; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                int dist = Math.abs(sum - target);
                if (dist < distance) {
                    ans = sum;
                    distance = dist;
                    if (distance == 0) {
                        return ans;
                    }
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

