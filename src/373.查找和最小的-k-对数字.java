/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的 K 对数字
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int target = binarySearch(nums1, nums2, k);
        List<List<Integer>> ans = new ArrayList<>();
        findSmallerPairs(ans, nums1, nums2, target);
        findKEqualsPairs(ans, nums1, nums2, target, k - ans.size());
        return ans;
    }
    int binarySearch(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int left = nums1[0] + nums2[0], right = nums1[m - 1] + nums2[n - 1] + 1;
        while (left < right) {
            int middle = left + (right - left >> 1);
            int row = m - 1, col = 0;
            long count = 0;
            while (row >= 0 && col < n) {
                if (nums1[row] + nums2[col] > middle) {
                    row--;
                } else {
                    col++;
                    count += row + 1;
                }
            }
            if (count < k) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
    void findSmallerPairs(List<List<Integer>> ans, int[] nums1, int[] nums2, int target) {
        int m = nums1.length, n = nums2.length;
        for (int row = 0, col = n - 1; row < m && col >= 0; row++) {
            while (col >= 0 && nums1[row] + nums2[col] >= target) {
                col--;
            }
            for (int i = 0; i <= col; i++) {
                ans.add(List.of(nums1[row], nums2[i]));
            }
        }
    }
    void findKEqualsPairs(List<List<Integer>> ans, int[] nums1, int[] nums2, int target, int k) {
        int m = nums1.length, n = nums2.length;
        for (int row = 0, col = n - 1; k > 0 && row < m && col >= 0; row++) {
            while (col >= 0 && nums1[row] + nums2[col] > target) {
                col--;
            }
            for (int i = col; i >= 0 && k > 0 && nums1[row] + nums2[i] == target; i--) {
                ans.add(List.of(nums1[row], nums2[i]));
                k--;
            }
        }
    }
}
// @lc code=end

