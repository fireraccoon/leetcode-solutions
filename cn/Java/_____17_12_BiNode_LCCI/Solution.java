// @algorithm @lc id=1000019 lang=java 
// @title binode-lcci
package _____17_12_BiNode_LCCI;
import algm.*;
// @test([4,2,5,1,3,null,6,0])=[0,null,1,null,2,null,3,null,4,null,5,null,6]
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
    private TreeNode head = null, pointer = new TreeNode();
    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return head;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (head == null) {
            head = root;
        }
        pointer.right = root;
        pointer = pointer.right;
        pointer.left = null;
        inorder(root.right);
    }
}