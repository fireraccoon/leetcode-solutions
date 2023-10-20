// @algorithm @lc id=100177 lang=java 
// @title legal-binary-search-tree-lcci
package _____04_05_Legal_Binary_Search_Tree_LCCI_1;
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val)
            && isValidBST(root.right, root.val, upper);
    }
}