/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }
    int partition(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int middle = (left + right) / 2;
        int leftAns = partition(nums, left, middle);
        int rightAns = partition(nums, middle + 1, right);
        if (leftAns == rightAns) {
            return leftAns;
        } else if (count(nums, leftAns, left, right) > count(nums, rightAns, left, right)) {
            return leftAns;
        } else {
            return rightAns;
        }
    }
    int count(int[] nums, int target, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

