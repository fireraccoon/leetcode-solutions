/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        int numOfNull = 0;
        queue.offer(root);
        while (!queue.isEmpty() && queue.size() > numOfNull) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
                if (node.left == null) {
                    numOfNull++;
                }
                if (node.right == null) {
                    numOfNull++;
                }
            } else {
                numOfNull--;
                sb.append("null,");
            }
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int n = data.length() - 1;
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 1;
        for (int index = 1; i < n; index++) {
            TreeNode parent = queue.peek(), node = null;
            if (index % 2 == 1) {
                queue.poll();
            }
            if (data.charAt(i) == 'n') {
                i += 5;
            } else {
                int signal = 1;
                if (data.charAt(i) == '-') {
                    signal = -1;
                    i++;
                }
                int number = Character.getNumericValue(data.charAt(i));
                while (++i < n && Character.isDigit(data.charAt(i))) {
                    number = number * 10 + Character.getNumericValue(data.charAt(i));
                }
                i++;
                node = new TreeNode(signal * number);
            }
            if (index == 1) {
                root = node;
            } else if (index % 2 == 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            if (node != null) {
                queue.offer(node);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

