/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    int pointer = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubtrees(preorder, map, 0, preorder.length - 1);
    }
    TreeNode buildSubtrees(int[] preorder, Map<Integer, Integer> inorder, int left, int right) {
        TreeNode root = new TreeNode(preorder[pointer++]);
        if (left == right) {
            return root;
        }
        int i = inorder.get(root.val);
        if (left < i) {
            root.left = buildSubtrees(preorder, inorder, left, i - 1);
        }
        if (i < right) {
            root.right = buildSubtrees(preorder, inorder, i + 1, right);
        }
        return root;
    }
}
// @lc code=end

