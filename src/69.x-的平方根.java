/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = Math.min(x, Integer.MAX_VALUE >> 15);
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            long pow = (long) middle * middle;
            if (pow == x) {
                return middle;
            } else if (pow > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left - 1;
    }
}
// @lc code=end

