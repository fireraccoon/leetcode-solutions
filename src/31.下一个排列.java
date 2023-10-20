/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int n = nums.length;
        int ni = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ni = i;
                break;
            }
        }
        int mi = n - 1;
        for (int i = n - 1; i > ni; i--) {
            if (nums[i] > nums[ni]) {
                mi = i;
                break;
            }
        }
        if (ni != n - 1) {
            swap(nums, ni, mi);
        } else {
            ni = -1;
        }
        reverse(nums, ni + 1, n - 1);
    }
    void swap(int[] arr, int i, int j) {
        int v = arr[i];
        arr[i] = arr[j];
        arr[j] = v;
    }
    void reverse(int[] arr, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }
}
// @lc code=end

