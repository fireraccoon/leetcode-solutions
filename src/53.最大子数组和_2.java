/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    class Result {
        public int lSum, rSum, sum, max;
        public Result(int lSum, int rSum, int sum, int max) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.sum = sum;
            this.max = max;
        }
    }
    public int maxSubArray(int[] nums) {
        return partition(nums, 0, nums.length - 1).max;
    }
    Result partition(int[] nums, int left, int right) {
        if (left == right) {
            return new Result(nums[left], nums[left], nums[left], nums[left]);
        }
        Result l = partition(nums, left, (right + left) >> 1);
        Result r = partition(nums, ((right + left) >> 1) + 1, right);
        return new Result(
            Math.max(l.lSum, l.sum + r.lSum),
            Math.max(r.rSum, l.rSum + r.sum),
            l.sum + r.sum,
            Math.max(Math.max(l.max, r.max), l.rSum + r.lSum)
        );
    }
}
// @lc code=end

