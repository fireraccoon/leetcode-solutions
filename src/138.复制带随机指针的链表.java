/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

import utils.linkedList.Node;

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node ans = new Node(0);
        for (Node pointer = head; pointer != null; pointer = pointer.next.next) {
            Node addedNode = new Node(pointer.val);
            addedNode.next = pointer.next;
            pointer.next = addedNode;
        }
        for (Node pointer = head; pointer != null; pointer = pointer.next.next) {
            Node random = pointer.random;
            if (random != null) {
                pointer.next.random = random.next;
            }
        }
        Node preHead = ans;
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            preHead.next = pointer.next;
            pointer.next = pointer.next.next;
            preHead = preHead.next;
        }
        return ans.next;
    }
}
// @lc code=end

