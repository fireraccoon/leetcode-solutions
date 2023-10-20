// @algorithm @lc id=100185 lang=java 
// @title rotate-matrix-lcci
package _____01_07_Rotate_Matrix_LCCI;
// @test([[1,2,3],[4,5,6],[7,8,9]])=[[7,4,1],[8,5,2],[9,6,3]]
// @test([[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]])=[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int leftTop = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = leftTop;
            }
        }
    }
}