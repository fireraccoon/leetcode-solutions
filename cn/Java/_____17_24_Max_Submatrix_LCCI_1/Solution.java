// @algorithm @lc id=1000046 lang=java 
// @title max-submatrix-lcci
package _____17_24_Max_Submatrix_LCCI_1;
// @test([[-1,0],[0,-1]])=[0,1,0,1]
public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[4];
        int[][] prefixSums = getPrefixSums(matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                getMaxMatrix(ans, prefixSums, i, j);
            }
        }
        return ans;
    }
    private void getMaxMatrix(int[] ans, int[][] prefixSums, int row, int col) {
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                int sum = prefixSums[row + 1][col + 1] + prefixSums[i][j]
                    - prefixSums[row + 1][j] - prefixSums[i][col + 1];
                if (sum > maxSum) {
                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = row;
                    ans[3] = col;
                    maxSum = sum;
                }
            }
        }
    }
    private int[][] getPrefixSums(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i + 1][1] = matrix[i][0] + dp[i][1];
        }
        for (int i = 1; i < n; i++) {
            dp[1][i + 1] = matrix[0][i] + dp[1][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i + 1][j + 1] = matrix[i][j] + dp[i][j + 1]
                    + dp[i + 1][j] - dp[i][j];
            }
        }
        return dp;
    }
}