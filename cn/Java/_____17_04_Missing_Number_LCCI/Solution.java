// @algorithm @lc id=1000032 lang=java 
// @title missing-number-lcci
package _____17_04_Missing_Number_LCCI;
// @test([3,0,1])=2
// @test([9,6,4,2,3,5,7,0,1])=8
public class Solution {
    public int missingNumber(int[] nums) {
        long sum = S_n(1, nums.length, nums.length);
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return (int) sum;
    }
    public long S_n(long a1, long an, long n) {
        return (a1 + an) * n / 2;
    }
}