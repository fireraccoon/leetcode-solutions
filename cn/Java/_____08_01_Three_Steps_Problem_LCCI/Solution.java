// @algorithm @lc id=100197 lang=java 
// @title three-steps-problem-lcci
package _____08_01_Three_Steps_Problem_LCCI;
// @test(3)=4
// @test(5)=13
public class Solution {
    private final static int MOD = 1_000_000_007;
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        int[][] matrix = new int[][] {
            { 1, 1, 1 },
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