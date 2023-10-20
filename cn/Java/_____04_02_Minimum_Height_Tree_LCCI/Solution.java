// @algorithm @lc id=100174 lang=java 
// @title minimum-height-tree-lcci
package _____04_02_Minimum_Height_Tree_LCCI;
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left >> 1);
        return new TreeNode(
            nums[middle],
            buildBST(nums, left, middle - 1),
            buildBST(nums, middle + 1, right));
    }
}