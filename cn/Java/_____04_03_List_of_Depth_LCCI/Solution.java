// @algorithm @lc id=100175 lang=java 
// @title list-of-depth-lcci
package _____04_03_List_of_Depth_LCCI;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algm.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (tree != null) {
            queue.offer(tree);
        }
        while (!queue.isEmpty()) {
            ListNode dummy = new ListNode(), pointer = dummy;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                pointer.next = new ListNode(node.val);
                pointer = pointer.next;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(dummy.next);
        }
        return ans.toArray(new ListNode[ans.size()]);
    }
}