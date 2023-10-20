// @algorithm @lc id=1000023 lang=java 
// @title the-masseuse-lcci
package _____17_16_The_Masseuse_LCCI;
// @test([1,2,3,1])=4
// @test([2,7,9,3,1])=12
// @test([2,1,4,5,3,1,1,3])=12
public class Solution {
    public int massage(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n == 0 ? 0 : nums[0];
        }
        int dp_0 = nums[0], dp_1 = Math.max(dp_0, nums[1]);
        for (int i = 2; i < n; i++) {
            int next = Math.max(dp_1, dp_0 + nums[i]);
            dp_0 = dp_1;
            dp_1 = next;
        }
        return dp_1;
    }
}