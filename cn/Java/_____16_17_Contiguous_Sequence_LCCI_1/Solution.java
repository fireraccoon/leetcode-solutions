// @algorithm @lc id=1000003 lang=java 
// @title contiguous-sequence-lcci
package _____16_17_Contiguous_Sequence_LCCI_1;
// @test([-2,1,-3,4,-1,2,1,-5,4])=6
public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sumToCurrent = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumToCurrent <= 0) {
                sumToCurrent = nums[i];
            } else {
                sumToCurrent += nums[i];
            }
            ans = Math.max(ans, sumToCurrent);
        }
        return ans;
    }
}