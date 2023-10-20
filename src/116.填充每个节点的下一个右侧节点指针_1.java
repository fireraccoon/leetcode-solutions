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
    int deepth = 0;
    Node lastNode;
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }
    void dfs(Node root) {
        if (root.left != null) {
            root.left.next = root.right;
            Node left = root.left, right = root.right;
            while (left.right != null) {
                left.right.next = right.left;
                left = left.right;
                right = right.left;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }
}
// @lc code=end

