/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */
// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return randomQuickSelect(nums, 0, nums.length - 1, k);
    }
    int randomQuickSelect(int[] nums, int left, int right, int k) {
        int pivotIndex = randomInt(left, right);
        int pivot = nums[pivotIndex];
        swap(nums, left, pivotIndex);
        int pointer = left + 1, smaller = left, larger = right + 1;
        while (pointer < larger) {
            if (nums[pointer] < pivot) {
                swap(nums, pointer++, ++smaller);
            } else if (nums[pointer] > pivot) {
                swap(nums, pointer, --larger);
            } else {
                pointer++;
            }
        }
        swap(nums, left, smaller);
        if (nums.length - k < smaller) {
            return randomQuickSelect(nums, left, smaller - 1, k);
        } else if (nums.length - k >= larger) {
            return randomQuickSelect(nums, larger, right, k);
        } else {
            return pivot;
        }
    }
    int randomInt(int left, int right) {
        return (int) ((right + 1 - left) * Math.random()) + left;
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

