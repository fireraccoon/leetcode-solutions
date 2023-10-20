/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, max = nums[0];
        int negetiveMin = nums[0], positiveMax = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                negetiveMin = Math.min(negetiveMin * nums[i], nums[i]);
                positiveMax = Math.max(positiveMax * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                int tmp = negetiveMin;
                negetiveMin = Math.min(positiveMax * nums[i], nums[i]);
                positiveMax = Math.max(tmp * nums[i], nums[i]);
            } else {
                negetiveMin = 0;
                positiveMax = 0;
            }
            max = Math.max(positiveMax, max);
        }
        return max;
    }
}
// @lc code=end

