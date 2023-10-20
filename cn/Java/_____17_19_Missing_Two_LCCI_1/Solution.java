// @algorithm @lc id=1000044 lang=java 
// @title missing-two-lcci
package _____17_19_Missing_Two_LCCI_1;
// @test([1])=[2,3]
// @test([2,3])=[4,1]
public class Solution {
    public int[] missingTwo(int[] nums) {
        int nSub2 = nums.length;
        boolean isNMissed = true, isNSub1Missed = true;
        for (int i = 0; i < nSub2; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < nSub2) {
                nums[index] = -nums[index];
            } else if (index == nSub2) {
                isNSub1Missed = false;
            } else {
                isNMissed = false;
            }
        }

        int count = 0;
        int[] ans = new int[2];
        if (isNSub1Missed) {
            ans[count++] = nSub2 + 1;
        }
        if (isNMissed) {
            ans[count++] = nSub2 + 2;
        }
        for (int i = 0; i < nums.length && count < 2; i++) {
            if (nums[i] > 0) {
                ans[count++] = i + 1;
            }
        }
        return ans;
    }
}