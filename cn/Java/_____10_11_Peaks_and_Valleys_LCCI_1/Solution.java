// @algorithm @lc id=1000013 lang=java 
// @title peaks-and-valleys-lcci
package _____10_11_Peaks_and_Valleys_LCCI_1;
// @test([5,3,1,2,3])=[2,1,3,3,5]
// @test([5,2,2,2,3])=[2,2,3,2,5]
import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            swap(nums, i - 1, i);
        }
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}