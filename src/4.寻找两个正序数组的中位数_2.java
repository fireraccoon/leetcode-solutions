/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */
//找最大满足nums1[p1] <= nums2[p2]的p1,p2

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = nums1.length, l2 = nums2.length;
        int lt = l1 + l2;
        int left = 0, right = l1;
        int lmax = 0, rmin = 0;
        while (left <= right) {
            int p1 = (left + right) / 2;
            int p2 = (lt + 1) / 2 - p1;
            int num1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
            int num1_ = p1 == l1 ? Integer.MAX_VALUE : nums1[p1];
            int num2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
            int num2_ = p2 == l2 ? Integer.MAX_VALUE : nums2[p2];
            if (num1 <= num2_) {
                lmax = Math.max(num1, num2);
                rmin = Math.min(num1_, num2_);
                left = p1 + 1;
            } else {
                right = p1 - 1;
            }
        }
        return lt % 2 != 0 ? lmax : (lmax + rmin) / 2.;
    }
}
// @lc code=end

