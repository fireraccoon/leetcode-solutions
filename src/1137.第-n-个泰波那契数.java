/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        if (n < 3) {
            return n == 0 ? 0 : 1;
        }
        int[][] matrix = new int[][] {
            { 1, 1, 1 },
            { 1, 0, 0 },
            { 0, 1, 0 }
        };
        matrix = quickPow(matrix, n);
        return matrix[2][0] + matrix[2][1];
    }
    int[][] quickPow(int[][] base, int pow) {
        int n = base.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            ans[i][i] = 1;
        }
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans = multiply(ans, base);
            }
            pow >>= 1;
            base = multiply(base, base);
        }
        return ans;
    }
    int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] ans = new int[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixB.length; k++) {
                    ans[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return ans;
    }
}
// @lc code=end

