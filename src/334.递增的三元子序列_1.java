/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] maxNums = new int[n]; 
        maxNums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxNums[i] = Math.max(maxNums[i + 1], nums[i]);
        }
        int min = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > min && nums[i] < maxNums[i + 1]) {
                return true;
            }
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
// @lc code=end

