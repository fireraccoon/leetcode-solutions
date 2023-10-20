/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */
// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[][] ans = quickPow(new int[][] {
            {1, 1},
            {1, 0}
        }, n - 2);
        return ans[0][0] * 2 + ans[0][1] * 1;
    }
    int[][] quickPow(int[][] matrix, int n) {
        int[][] ans = new int[][] {
            {1, 0},
            {0, 1}
        };
        while (n > 0) {
            if ((n & 0b1) == 1) {
                ans = multiply(ans, matrix);
            }
            n >>= 1;
            matrix = multiply(matrix, matrix);
        }
        return ans;
    }
    int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] ans = new int[matrixA.length][matrixB.length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB.length; j++) {
                for (int k = 0; k < matrixA.length; k++) {
                    ans[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return ans;
    }
}
// @lc code=end
