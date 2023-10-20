/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */
// @lc code=start
class Solution {
    private final static int BUCKET_SIZE = 5;
    public int findKthLargest(int[] nums, int k) {
        return medianOfMedians(nums, 0, nums.length, nums.length - k);
    }
    int medianOfMedians(int[] nums, int left, int right, int k) {
        int n = right - left;
        if (n <= 5) {
            insertionSort(nums, left, right);
            return nums[left + k];
        }

        int[] medians = getMedians(nums, left, right);

        int pivot = medianOfMedians(medians, 0, medians.length, medians.length / 2);

        int[] bounds = partitionByPivot(nums, left, right, pivot);

        if (k < bounds[0] - left) {
            return medianOfMedians(nums, left, bounds[0], k);
        } else if (k >= bounds[1] - left) {
            return medianOfMedians(nums, bounds[1], right, k - (bounds[1] - left));
        } else {
            return pivot;
        }
    }
    int[] getMedians(int[] nums, int left, int right) {
        int[] medians = new int[(right - left + BUCKET_SIZE - 1) / BUCKET_SIZE];
        for (int i = left, j = 0; i < right; i += BUCKET_SIZE) {
            int length = Math.min(right - i, BUCKET_SIZE);
            insertionSort(nums, i, i + length);
            medians[j++] = nums[i + length / 2];
        }
        return medians;
    }
    int[] partitionByPivot(int[] nums, int left, int right, int pivot) {
        int pointer = left;
        int smaller = left, larger = right;
        while (pointer < larger) {
            if (nums[pointer] < pivot) {
                swap(nums, pointer++, smaller++);
            } else if (nums[pointer] > pivot) {
                swap(nums, pointer, --larger);
            } else {
                pointer++;
            }
        }
        return new int[] {smaller, larger};
    }
    void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            int num = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > num) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = num;
        }
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

