// @algorithm @lc id=100229 lang=java 
// @title check-subtree-lcci
package _____04_10_Check_SubTree_LCCI_1;
// @test([1,2,3],[2])=true
// @test([1,null,2,4],[3,2])=false
// @test([1,2,3,4,5],[2])=false
// @test([],[2])=false
// @test([],[])=true
// @test([2],[])=false
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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null ^ t2 == null) {
            return false;
        }
        return contains(t1, t2) || contains(t1, t2)
            || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
    public boolean contains(TreeNode root, TreeNode target) {
        if (root == null) {
            return target == null;
        }
        if (target == null) {
            return false;
        }
        return root.val == target.val && contains(root.left, target.left)
            && contains(root.right, target.right);
    }
}