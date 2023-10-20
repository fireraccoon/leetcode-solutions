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
        Node left = new Node();
        while (parent != null) {
            Node pointer = left;
            left.next = null;
            while (parent != null) {
                if (parent.left != null) {
                    pointer.next = parent.left;
                    pointer = pointer.next;
                }
                if (parent.right != null) {
                    pointer.next = parent.right;
                    pointer = pointer.next;
                }
                parent = parent.next;
            }
            parent = left.next;
        }
        return root;
    }
}
// @lc code=end

