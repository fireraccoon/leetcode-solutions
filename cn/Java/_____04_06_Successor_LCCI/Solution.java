// @algorithm @lc id=100178 lang=java 
// @title successor-lcci
package _____04_06_Successor_LCCI;
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        if (p.right != null) {
            ans = p.right;
            while (ans.left != null) {
                ans = ans.left;
            }
            return ans;
        }
        TreeNode pointer = root;
        while (pointer != null) {
            if (p.val < pointer.val) {
                ans = pointer;
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }
        return ans;
    }
}