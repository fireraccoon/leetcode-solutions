// @algorithm @lc id=1000044 lang=java 
// @title missing-two-lcci
package _____17_19_Missing_Two_LCCI;
// @test([1])=[3,2]
// @test([2,3])=[1,4]
public class Solution {
    public int[] missingTwo(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i + 1;
        }
        xor ^= nums.length + 1;
        xor ^= nums.length + 2;

        int xor1 = 0, xor2 = 0;
        int lowbit = xor & -xor;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & lowbit) != 0) {
                xor1 ^= nums[i];
            } else {
                xor2 ^= nums[i];
            }
        }
        for (int i = nums.length + 2; i >= 1; i--) {
            if ((i & lowbit) != 0) {
                xor1 ^= i;
            } else {
                xor2 ^= i;
            }
        }
        return new int[] { xor1, xor2 };
    }
}