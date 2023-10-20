/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums);
        for (int i = 1; i < k; i++) {
            heap.pop();
        }
        return heap.pop();
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private class MaxHeap {

        private int[] nums;

        private int size;

        public MaxHeap(int[] nums) {
            this.nums = nums;
            size = nums.length;
            heapify();
        }

        public int pop() {
            swap(nums, 0, --size);
            shiftDown(0);
            return nums[size];
        }

        private void heapify() {
            for (int i = (nums.length - 2) / 2; i >= 0; i--) {
                shiftDown(i);
            }
        }

        private void shiftDown(int parent) {
            int child = parent * 2 + 1;
            while (child < size) {
                if (child + 1 < size && nums[child] < nums[child + 1]) {
                    child++;
                }
                if (nums[parent] >= nums[child]) {
                    return;
                } else {
                    swap(nums, parent, child);
                    parent = child;
                    child = parent * 2 + 1;
                }
            }
        }
    }
}
// @lc code=end

