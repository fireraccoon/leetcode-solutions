/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i];
        }
        int product = 1;
        for (int i = n - 1; i > 0; i--) {
            ans[i] = product * ans[i - 1];
            product *= nums[i];
        }
        ans[0] = product;
        return ans;
    }
}
// @lc code=end

