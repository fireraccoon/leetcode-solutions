/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] backup = new int[nums.length];
        System.arraycopy(nums, 0, backup, 0, nums.length);
        int[] indices = new int[nums.length], ans = new int[nums.length];
        mergeSort(ans, indices, backup, 0, backup.length - 1);
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ansList.add(ans[i]);
        }
        return ansList;
    }
    private void mergeSort(int[] ans, int[] indices, int[] nums, int left, int right) {
        if (left == right) {
            indices[left] = left;
            return;
        }
        int middle = left + (right - left >> 1);
        mergeSort(ans, indices, nums, left, middle);
        mergeSort(ans, indices, nums, middle + 1, right);
        if (nums[middle] <= nums[middle + 1]) {
            return;
        }
        merge(ans, indices, nums, left, middle, middle + 1, right);
    }
    private void merge(int[] ans, int[] indices, int[] nums, int l1, int r1, int l2, int r2) {
        int[] tmp = new int[r2 + 1 - l1];
        int[] indicesTmp = new int[tmp.length];
        int pointer = 0;
        while (pointer < tmp.length) {
            if (l1 > r1) {
                tmp[pointer] = nums[l2];
                indicesTmp[pointer++] = indices[l2++];
            } else if (l2 > r2 || nums[l1] <= nums[l2]) {
                tmp[pointer] = nums[l1];
                indicesTmp[pointer++] = indices[l1];
                ans[indices[l1++]] += l2 - r1 - 1;
            } else {
                tmp[pointer] = nums[l2];
                indicesTmp[pointer++] = indices[l2++];
            }
        }
        System.arraycopy(tmp, 0, nums, r2 + 1 - tmp.length, tmp.length);
        System.arraycopy(indicesTmp, 0, indices, r2 + 1 - tmp.length, tmp.length);
    }
}
// @lc code=end

