// @algorithm @lc id=1000003 lang=java 
// @title contiguous-sequence-lcci
package _____16_17_Contiguous_Sequence_LCCI;
// @test([-2,1,-3,4,-1,2,1,-5,4])=6
public class Solution {
    public int maxSubArray(int[] nums) {
        return partition(nums, 0, nums.length - 1)[1];
    }
    public int[] partition(int[] nums, int left, int right) {
        if (left == right) {
            return new int[] { nums[left], nums[left], nums[left], nums[left] };
        }

        int middle = left + (right - left >> 1);
        int[] leftSubAns = partition(nums, left, middle);
        int[] rightSubAns = partition(nums, middle + 1, right);
        return new int[] {
            Math.max(leftSubAns[3] + rightSubAns[0], leftSubAns[0]),
            Math.max(leftSubAns[2] + rightSubAns[0], Math.max(leftSubAns[1], rightSubAns[1])),
            Math.max(leftSubAns[2] + rightSubAns[3], rightSubAns[2]),
            leftSubAns[3] + rightSubAns[3]
        };
    }
}