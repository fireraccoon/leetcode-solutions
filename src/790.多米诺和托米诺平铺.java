/*
 * @lc app=leetcode.cn id=790 lang=java
 *
 * [790] 多米诺和托米诺平铺
 */

// @lc code=start
class Solution {
    private final static int MOD = 1_000_000_007;
    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        int[][] matrix = new int[][] {
            { 2, 0, 1 },
            { 1, 0, 0 },
            { 0, 1, 0 }
        };
        matrix = quickPow(matrix, n);
        return ((matrix[2][0] * 2 % MOD + matrix[2][1]) % MOD + matrix[2][2]) % MOD;
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
                    ans[i][j] = (int) ((ans[i][j] + (long) matrixA[i][k] * matrixB[k][j]) % MOD);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

