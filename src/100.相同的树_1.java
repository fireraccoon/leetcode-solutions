/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        TreeNode pointerP, pointerQ;
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            pointerP = queueP.poll();
            pointerQ = queueQ.poll();
            if (pointerP == null && pointerQ == null) {
                continue;
            }
            if (pointerP == null || pointerQ == null || pointerP.val != pointerQ.val) {
                return false;
            }
            queueP.offer(pointerP.left);
            queueP.offer(pointerP.right);
            queueQ.offer(pointerQ.left);
            queueQ.offer(pointerQ.right);
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
// @lc code=end

