// @algorithm @lc id=100179 lang=java 
// @title first-common-ancestor-lcci
package _____04_08_First_Common_Ancestor_LCCI;
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
    TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }
    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean inLeft = dfs(root.left, p, q);
        boolean inRight = dfs(root.right, p, q);
        if (inLeft && inRight || (root == p || root == q) && (inLeft || inRight)) {
            ancestor = root;
        }
        return inLeft || inRight || root == p || root == q;
    }
}