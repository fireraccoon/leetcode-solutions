/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    public int kthSmallest(TreeNode root, int k) {
        KthRecordTree kthRecordTree = new KthRecordTree(root);
        return kthRecordTree.getKthSmallestValue(k);
    }
    private class KthRecordTree {

        private TreeNode root;

        private Map<TreeNode, Integer> nodeCount = new HashMap<>();

        public KthRecordTree(TreeNode root) {
            this.root = root;
            countNode(root);
        }

        private int countNode(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int count = 1 + countNode(root.left) + countNode(root.right);
            nodeCount.put(root, count);
            return count;
        }

        public int getKthSmallestValue(int k) {
            TreeNode pointer = root;
            int index = nodeCount.get(pointer) - nodeCount.getOrDefault(pointer.right, 0);
            while (k != index) {
                if (k < index) {
                    pointer = pointer.left;
                    index -= 1 + nodeCount.getOrDefault(pointer.right, 0);
                } else {
                    pointer = pointer.right;
                    index += 1 + nodeCount.getOrDefault(pointer.left, 0);
                }
            }
            return pointer.val;
        }
    }
}
// @lc code=end

