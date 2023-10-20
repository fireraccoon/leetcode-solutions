// @algorithm @lc id=1000013 lang=java 
// @title peaks-and-valleys-lcci
package _____10_11_Peaks_and_Valleys_LCCI;
// @test([5,3,1,2,3])=[3,5,1,3,2]
// @test([5,2,2,2,3])=[2,5,2,3,2]
public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 1 && nums[i] < nums[i - 1]
                || (i & 1) == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}