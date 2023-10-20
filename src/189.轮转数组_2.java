/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] tmp = new int[n];
        k %= n;
        System.arraycopy(nums, 0, tmp, k, n - k);
        System.arraycopy(nums, n - k, tmp, 0, k);
        System.arraycopy(tmp, 0, nums, 0, n);
    }
}
// @lc code=end

