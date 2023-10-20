/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int lt = l1 + l2;
        if (lt % 2 != 0) {
            return topK(nums1, nums2, lt / 2 + 1);
        } else {
            return (topK(nums1, nums2, lt / 2) + topK(nums1, nums2, lt / 2 + 1)) / 2.;
        }
    }
    int topK(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int p1s = 0, p2s = 0;
        int pk;
        while (true) {
            if (p1s == l1) {
                return nums2[p2s+k-1];
            }
            if (p2s == l2) {
                return nums1[p1s+k-1];
            }
            if (k == 1) {
                return Math.min(nums1[p1s], nums2[p2s]);
            }
            pk = k / 2;
            int i1 = Math.min(p1s + pk, l1) - 1;
            int i2 = Math.min(p2s + pk, l2) - 1;
            if (nums1[i1] <= nums2[i2]) {
                k -= i1 - p1s + 1;
                p1s = i1 + 1;
            } else {
                k -= i2 - p2s + 1;
                p2s = i2 + 1;
            }
        }
    }
}
// @lc code=end

