/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        int dPointer = 0;
        d[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[dPointer]) {
                d[++dPointer] = nums[i];
            } else {
                int left = 0, right = dPointer;
                while (left < right) {
                    int middle = left + right >> 1;
                    if (nums[i] > d[middle]) {
                        left = middle + 1;
                    } else {
                        right = middle;
                    }
                }
                d[left] = nums[i];
            }
        }
        return dPointer + 1;
    }
}
// @lc code=end

