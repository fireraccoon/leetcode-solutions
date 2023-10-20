/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

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

    private StringBuilder buffer;

    private int pointer;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        buffer = new StringBuilder("[");
        dfsForSerialize(root);
        buffer.setCharAt(buffer.length() - 1, ']');
        return buffer.toString();
    }

    private void dfsForSerialize(TreeNode root) {
        if (root == null) {
            buffer.append("null").append(",");
            return;
        }
        buffer.append(root.val).append(",");
        dfsForSerialize(root.left);
        dfsForSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        pointer = 1;
        return dfsForDeserialize(data);
    }

    private TreeNode dfsForDeserialize(String data) {
        int n = data.length() - 1;
        if (pointer >= n) {
            return null;
        }
        if (data.charAt(pointer) == 'n') {
            pointer += 5;
            return null;
        }
        int signal = 1;
        if (data.charAt(pointer) == '-') {
            pointer++;
            signal = -1;
        }
        int number = Character.getNumericValue(data.charAt(pointer));
        while (++pointer < n && Character.isDigit(data.charAt(pointer))) {
            number = number * 10 + Character.getNumericValue(data.charAt(pointer));
        }
        pointer++;
        TreeNode node = new TreeNode(signal * number);
        node.left = dfsForDeserialize(data);
        node.right = dfsForDeserialize(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

