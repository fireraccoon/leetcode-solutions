/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        int shuffixSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            shuffixSum += nums[i];
        }
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            shuffixSum -= nums[i];
            if (prefixSum == shuffixSum) {
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }
}
// @lc code=end

