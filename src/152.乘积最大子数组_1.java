/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], n = nums.length;
        int[] negetive = new int[n];
        int[] positive = new int[n];
        negetive[0] = nums[0];
        positive[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                negetive[i] = Math.min(negetive[i - 1] * nums[i], nums[i]);
                positive[i] = Math.max(positive[i - 1] * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                negetive[i] = Math.min(positive[i - 1] * nums[i], nums[i]);
                positive[i] = Math.max(negetive[i - 1] * nums[i], nums[i]);
            } else {
                negetive[i] = 0;
                positive[i] = 0;
            }
            max = Math.max(max, positive[i]);
        }
        return max;
    }
}
// @lc code=end

