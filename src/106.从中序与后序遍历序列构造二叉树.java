/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

import java.util.HashMap;
import java.util.Map;

import utils.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int pointer;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pointer = inorder.length - 1;
        return buildSubTrees(inorder, postorder, map, 0, pointer);
    }
    TreeNode buildSubTrees(int[] inorder, int[] postorder, Map<Integer, Integer> map, int left, int right) {
        TreeNode root = new TreeNode(postorder[pointer--]);
        if (left == right) {
            return root;
        }
        int index = map.get(root.val);
        if (index < right) {
            root.right = buildSubTrees(inorder, postorder, map, index + 1, right);
        }
        if (index > left) {
            root.left = buildSubTrees(inorder, postorder, map, left, index - 1);
        }
        return root;
    }
}
// @lc code=end

