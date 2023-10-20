// @algorithm @lc id=100176 lang=java 
// @title check-balance-lcci
package _____04_04_Check_Balance_LCCI;
import algm.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getBalanceHeight(root) != -1;
    }

    public int getBalanceHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getBalanceHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getBalanceHeight(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}