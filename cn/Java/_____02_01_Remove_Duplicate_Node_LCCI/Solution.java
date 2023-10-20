// @algorithm @lc id=100163 lang=java 
// @title remove-duplicate-node-lcci
package _____02_01_Remove_Duplicate_Node_LCCI;
import java.util.HashSet;
import java.util.Set;
import algm.*;
// @test([1,2,3,3,2,1])=[1,2,3]
// @test([1,1,1,1,2])=[1,2]
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(), pointer = dummy;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.add(head.val)) {
                pointer.next = head;
                pointer = pointer.next;
            }
            head = head.next;
        }
        pointer.next = null;
        return dummy.next;
    }
}