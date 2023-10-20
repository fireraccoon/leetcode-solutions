// @algorithm @lc id=1000019 lang=java 
// @title binode-lcci
package _____17_12_BiNode_LCCI_1;
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
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = null, pointer = root, right;
        for (TreeNode next; pointer != null; pointer = next) {
            right = pointer;
            while (right.right != null) {
                right = right.right;
            }
            pointer.right = convertBiNode(pointer.right);
            right.right = head;
            head = pointer;
            next = pointer.left;
            pointer.left = null;
        }
        return head;
    }
}