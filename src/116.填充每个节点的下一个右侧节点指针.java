/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
            return null;
        }
        Node parent = root;
        Node left, leftmost;
        while (parent.left != null) {
            left = parent.left;
            leftmost = left;
            left.next = parent.right;
            while (parent.next != null) {
                parent = parent.next;
                left = left.next;
                left.next = parent.left;
                left = left.next;
                left.next = parent.right;
            }
            parent = leftmost;
        }
        return root;
    }
}
// @lc code=end

