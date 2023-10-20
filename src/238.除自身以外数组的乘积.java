/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int leftProduct = 1, rightProduct = 1;
        Arrays.fill(ans, 1);
        for (int i = 0; i < n; i++) {
            ans[i] *= leftProduct;
            ans[n - i - 1] *= rightProduct;
            leftProduct *= nums[i];
            rightProduct *= nums[n - i - 1];
        }
        return ans;
    }
}
// @lc code=end

