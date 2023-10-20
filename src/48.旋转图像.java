/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */
 
// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            int bound = n - i - 1;
            for (int j = i; j < bound; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[bound][j];
                matrix[bound][j] = matrix[bound-(j-i)][bound];
                matrix[bound-(j-i)][bound] = matrix[i][bound-(j-i)];
                matrix[i][bound-(j-i)] = tmp;
            }
        }
    }
}
// @lc code=end

