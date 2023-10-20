/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target,
            new Coordinate(0, 0), new Coordinate(matrix.length - 1, matrix[0].length - 1));
    }
    private boolean searchMatrix(int[][] matrix, int target, Coordinate lt, Coordinate rb) {
        if (matrix[lt.row][lt.col] == target || matrix[rb.row][rb.col] == target) {
            return true;
        }
        if (matrix[lt.row][lt.col] > target || matrix[rb.row][rb.col] < target) {
            return false;
        }
        if (lt.col == rb.col) {
            return binarySearchForCol(matrix, lt.col, lt.row, rb.row, target);
        }
        if (lt.row == rb.row) {
            return Arrays.binarySearch(matrix[lt.row], lt.col, rb.col + 1, target) >= 0;
        }
        int leftTopRow = lt.row, leftTopCol = lt.col;
        int rightBottomRow = rb.row, rightBottomCol = rb.col;
        while (leftTopRow < rightBottomRow - 1 && leftTopCol < rightBottomCol - 1) {
            int middleRow = (leftTopRow + rightBottomRow) >>> 1;
            int middleCol = (leftTopCol + rightBottomCol) >>> 1;
            if (matrix[middleRow][middleCol] < target) {
                leftTopRow = middleRow;
                leftTopCol = middleCol;
            } else if (matrix[middleRow][middleCol] > target) {
                rightBottomRow = middleRow;
                rightBottomCol = middleCol;
            } else {
                return true;
            }
        }
        return searchMatrix(matrix, target, new Coordinate(leftTopRow + 1, lt.col), new Coordinate(rb.row, rightBottomCol - 1))
            || searchMatrix(matrix, target, new Coordinate(lt.row, leftTopCol + 1), new Coordinate(rightBottomRow - 1, rb.col));
    }
    private boolean binarySearchForCol(int[][] matrix, int col, int top, int bottom, int target) {
        while (top <= bottom) {
            int middle = (top + bottom) >>> 1;
            if (matrix[middle][col] == target) {
                return true;
            } else if (matrix[middle][col] > target) {
                bottom = middle - 1;
            } else {
                top = middle + 1;
            }
        }
        return false;
    }
    private class Coordinate {
        public int col;
        public int row;
        public Coordinate(int row, int col) {
            this.col = col;
            this.row = row;
        }
    }
}
// @lc code=end

