/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */
// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int ans = binarySearch(sums, target, 0, n - 1);
        for (int i = 1; i < n; i++) {
            ans = Math.min(binarySearch(sums, target + sums[i - 1], i, n - 1), ans);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    int binarySearch(int[] nums, int target, int left, int right) {
        int begin = left;
        if (nums[left] >= target) {
            return 1;
        }
        left++;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle - 1] < target && nums[middle] >= target) {
                return middle - begin + 1;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
// @lc code=end

