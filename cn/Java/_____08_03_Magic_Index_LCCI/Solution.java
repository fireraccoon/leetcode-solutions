// @algorithm @lc id=100240 lang=java 
// @title magic-index-lcci
package _____08_03_Magic_Index_LCCI;
// @test([0,2,3,4,5])=0
// @test([1,1,1])=1
public class Solution {
    public int findMagicIndex(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }
    int partition(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left] == left ? left : -1;
        }
        int middle = left + (right - left >> 1);
        int leftAns = partition(nums, left, middle);
        if (leftAns != -1) {
            return leftAns;
        } else {
            return partition(nums, middle + 1, right);
        }
    }
}