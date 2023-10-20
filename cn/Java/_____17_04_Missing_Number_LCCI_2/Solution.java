// @algorithm @lc id=1000032 lang=java 
// @title missing-number-lcci
package _____17_04_Missing_Number_LCCI_2;
// @test([3,0,1])=2
// @test([9,6,4,2,3,5,7,0,1])=8
public class Solution {
    public int missingNumber(int[] nums) {
        boolean isNLost = true;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index == nums.length) {
                isNLost = false;
            } else {
                nums[index] = -nums[index];
            }
        }

        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            } else if (nums[i] > 0) {
                return i;
            } else {
                zeroIndex = i;
            }
        }
        return isNLost ? nums.length : zeroIndex;
    }
}