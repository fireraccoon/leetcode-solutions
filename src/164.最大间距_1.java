/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */
// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        radixSort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
    void radixSort(int[] nums) {
        int max = getMax(nums);
        for (int radix = 1; radix <= max; radix *= 10) {
            countSort(nums, radix);
        }
    }
    void countSort(int[] nums, int radix) {
        int n = nums.length;
        int[] count = new int[10];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            count[nums[i] / radix % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = nums[i] / radix % 10;
            count[digit]--;
            sorted[count[digit]] = nums[i];
        }
        System.arraycopy(sorted, 0, nums, 0, n);
    }
    int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
// @lc code=end

