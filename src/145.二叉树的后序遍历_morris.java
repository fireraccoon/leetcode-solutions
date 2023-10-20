/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode pointer = root, predecessor;
        while (pointer != null) {
            if (pointer.left != null) {
                predecessor = pointer.left;
                while (predecessor.right != null && predecessor.right != pointer) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == pointer) {
                    predecessor.right = null;
                    addReverseNodes(ans, pointer.left);
                    pointer = pointer.right;
                } else {
                    predecessor.right = pointer;
                    pointer = pointer.left;
                }
            } else {
                pointer = pointer.right;
            }
        }
        addReverseNodes(ans, root);
        return ans;
    }
    void addReverseNodes(List<Integer> ans, TreeNode node) {
        int count = 0;
        while (node != null) {
            ans.add(node.val);
            node = node.right;
            count++;
        }
        for (int left = ans.size() - count, right = ans.size() - 1; left < right;) {
            int tmp = ans.get(left);
            ans.set(left, ans.get(right));
            ans.set(right, tmp);
            left++;
            right--;
        }
    }
}
// @lc code=end

