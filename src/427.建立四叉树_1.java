/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int[][] prefixSums = new int[grid.length + 1][grid.length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid.length; j++) {
                prefixSums[i][j] = grid[i - 1][j - 1] - prefixSums[i - 1][j - 1]
                    + prefixSums[i - 1][j] + prefixSums[i][j - 1];
            }
        }
        return recursion(prefixSums, 0, grid.length - 1, 0, grid.length - 1);
    }
    Node recursion(int[][] prefixSums, int left, int right, int top, int bottom) {
        int sum = prefixSums[bottom + 1][right + 1] + prefixSums[top][left]
            - prefixSums[top][right + 1] - prefixSums[bottom + 1][left];
        if (sum == 0) {
            return new Node(false, true);
        } else if (sum == (right - left + 1) * (bottom - top + 1)) {
            return new Node(true, true);
        }

        int middleX = left + (right - left >> 1);
        int middleY = top + (bottom - top >> 1);
        return new Node(false, false,
            recursion(prefixSums, left, middleX, top, middleY),
            recursion(prefixSums, middleX + 1, right, top, middleY),
            recursion(prefixSums, left, middleX, middleY + 1, bottom),
            recursion(prefixSums, middleX + 1, right, middleY + 1, bottom));
    }
}
// @lc code=end

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};