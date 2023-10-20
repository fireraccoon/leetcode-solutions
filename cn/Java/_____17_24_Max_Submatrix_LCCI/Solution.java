// @algorithm @lc id=1000046 lang=java 
// @title max-submatrix-lcci
package _____17_24_Max_Submatrix_LCCI;
// @test([[-1,0],[0,-1]])=[0,1,0,1]
public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];
        int[][] colPrefixSums = getColPrefixSums(matrix);
        for (int i = 0; i < matrix.length; i++) {
            getMaxMatrix(ans, matrix, colPrefixSums, i);
        }
        return ans;
    }
    public void getMaxMatrix(int[] ans, int[][] matrix, int[][] colPrefixSums, int row) {
        int n = matrix[0].length;
        for (int i = 0; i <= row; i++) {
            int sum = 0, left = 0;
            for (int col = 0; col < n; col++) {
                int num = colPrefixSums[row + 1][col + 1] - colPrefixSums[i][col + 1];
                if (sum <= 0) {
                    sum = num;
                    left = col;
                } else {
                    sum += num;
                }
                if (sum > maxSum) {
                    ans[0] = i;
                    ans[1] = left;
                    ans[2] = row;
                    ans[3] = col;
                    maxSum = sum;
                }
            }
        }
    }
    private int[][] getColPrefixSums(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = matrix[i][j] + dp[i][j + 1];
            }
        }
        return dp;
    }
}