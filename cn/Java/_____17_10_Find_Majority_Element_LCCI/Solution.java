// @algorithm @lc id=1000038 lang=java 
// @title find-majority-element-lcci
package _____17_10_Find_Majority_Element_LCCI;
// @test([1,2,5,9,5,9,5,5,5])=5
// @test([3,2])=-1
// @test([2,2,1,1,1,2,2])=2
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else if (--count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }
        return count > nums.length / 2 ? candidate : -1;
    }
}