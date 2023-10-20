/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

import java.util.HashMap;
import java.util.Map;

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
        Node preHead = ans;
        Map<Node, Node> memory = new HashMap<>();
        while (head != null) {
            preHead.next = memory.getOrDefault(head, new Node(head.val));
            preHead = preHead.next;
            memory.putIfAbsent(head, preHead);
            if (head.random != null) {
                preHead.random = memory.getOrDefault(head.random, new Node(head.random.val));
                memory.putIfAbsent(head.random, preHead.random);
            }
            head = head.next;
        }
        return ans.next;
    }
}
// @lc code=end

