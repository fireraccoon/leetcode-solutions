/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

import utils.Node;

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node parent = root;
        Node pointer = null;
        Node nextParent = parent;
        boolean isNextParentChange = parent.left != null || parent.right != null;
        while (isNextParentChange) {
            isNextParentChange = false;
            if (parent.left != null) {
                pointer = parent.left;
                if (!isNextParentChange && (pointer.left != null || pointer.right != null)) {
                    nextParent = pointer;
                    isNextParentChange = true;
                }
            }
            if (parent.right != null) {
                if (parent.left != null) {
                    pointer.next = parent.right;
                    pointer = pointer.next;
                } else {
                    pointer = parent.right;
                }
                if (!isNextParentChange && (pointer.left != null || pointer.right != null)) {
                    nextParent = pointer;
                    isNextParentChange = true;
                }
            }
            while (parent.next != null) {
                parent = parent.next;
                if (parent.left != null) {
                    pointer.next = parent.left;
                    pointer = pointer.next;
                    if (!isNextParentChange && (pointer.left != null || pointer.right != null)) {
                        nextParent = pointer;
                        isNextParentChange = true;
                    }
                }
                if (parent.right != null) {
                    pointer.next = parent.right;
                    pointer = pointer.next;
                    if (!isNextParentChange && (pointer.left != null || pointer.right != null)) {
                        nextParent = pointer;
                        isNextParentChange = true;
                    }
                }
            }
            if (isNextParentChange) {
                parent = nextParent;
            }
        }
        return root;
    }
}
// @lc code=end

