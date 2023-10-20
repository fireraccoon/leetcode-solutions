// @algorithm @lc id=1000045 lang=java 
// @title max-black-square-lcci
package _____17_23_Max_Black_Square_LCCI;
// @test([[1,0,1],[0,0,1],[0,0,1]])=[1,0,2]
// @test([[0,1,1],[1,0,1],[1,1,0]])=[0,0,1]
public class Solution {
    public int[] findSquare(int[][] matrix) {
        int[] ans = new int[] { -1, -1, 0 };
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i == 0 ? 0 : dp[i - 1][j];
                int left = j == 0 ? 0 : dp[i][j - 1];
                if (matrix[i][j] == 0) {
                    dp[i][j] = extend(left, top);
                    updateAnswer(ans, dp, i, j);
                }
            }
        }
        return ans[2] > 0 ? ans : new int[0];
    }
    private int extend(int left, int top) {
        return (left >>> 16) + 1 << 16 | (top & 0xffff) + 1;
    }
    private void updateAnswer(int[] ans, int[][] dp, int row, int col) {
        int length = Math.min(dp[row][col] >>> 16, dp[row][col] & 0xffff);
        while (length > ans[2]) {
            if (dp[row - length + 1][col] >>> 16 >= length && (dp[row][col - length + 1] & 0xffff) >= length) {
                ans[0] = row - length + 1;
                ans[1] = col - length + 1;
                ans[2] = length;
            }
            length--;
        }
    }
}