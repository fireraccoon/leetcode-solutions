/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp_row = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp_row[i] = 1;
                ans = Math.max(ans, 1);
            }
        }
        for (int i = 1; i < m; i++) {
            int nextPre = dp_row[0];
            if (matrix[i][0] == '1') {
                dp_row[0] = 1;
                ans = Math.max(ans, 1);
            } else {
                dp_row[0] = 0;
            }
            int pre = nextPre;
            for (int j = 1; j < n; j++) {
                nextPre = dp_row[j];
                if (matrix[i][j] == '1') {
                    dp_row[j] = 1 + Math.min(
                        Math.min(dp_row[j], dp_row[j - 1]),
                        pre);
                    ans = Math.max(ans, dp_row[j]);
                } else {
                    dp_row[j] = 0;
                }
                pre = nextPre;
            }
        }
        return ans * ans;
    }
}
// @lc code=end

