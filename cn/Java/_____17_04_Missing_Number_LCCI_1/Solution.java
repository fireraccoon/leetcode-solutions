// @algorithm @lc id=1000032 lang=java 
// @title missing-number-lcci
package _____17_04_Missing_Number_LCCI_1;
// @test([3,0,1])=2
// @test([9,6,4,2,3,5,7,0,1])=8
public class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        return ans ^ nums.length;
    }
}