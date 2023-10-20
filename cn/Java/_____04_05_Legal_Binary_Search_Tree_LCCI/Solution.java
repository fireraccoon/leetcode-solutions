// @algorithm @lc id=100177 lang=java 
// @title legal-binary-search-tree-lcci
package _____04_05_Legal_Binary_Search_Tree_LCCI;
// @test([5,1,4,null,null,3,6])=false
// @test([-2147483648])=true
// @test([1,1])=false
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
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return inorder(root.right);
    }
}