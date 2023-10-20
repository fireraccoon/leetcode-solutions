/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int compare = matrix[middle / n][middle % n] - target;
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
// @lc code=end

