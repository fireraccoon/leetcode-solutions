/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int middle = left + ((right - left) >>> 1);
            if (!isBadVersion(middle)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return right;
    }
}
// @lc code=end

class VersionControl {
    boolean isBadVersion(int version) {
        throw new UnsupportedOperationException("Method for local test.");
    }
}
