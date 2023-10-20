/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] prefixZeroSums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixZeroSums[i] = prefixZeroSums[i - 1] + (1 - nums[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            ans = Math.max(ans, right - binarySearch(prefixZeroSums, prefixZeroSums[right + 1] - k) + 1);
        }
        return ans;
    }
    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int middle = l + (r - l >> 1);
            if (nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle;
            }
        }
        return l;
    }
}
// @lc code=end

