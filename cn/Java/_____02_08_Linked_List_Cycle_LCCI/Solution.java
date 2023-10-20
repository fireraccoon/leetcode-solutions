// @algorithm @lc id=100168 lang=java 
// @title linked-list-cycle-lcci
package _____02_08_Linked_List_Cycle_LCCI;
import algm.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        for (boolean isSlowIncreased = true; fast != null; isSlowIncreased = !isSlowIncreased) {
            fast = fast.next;
            if (!isSlowIncreased) {
                slow = slow.next;
                if (slow == fast) {
                    break;
                }
            }
        }
        if (fast == null) {
            return null;
        }
        for (fast = head; slow != fast;
            slow = slow.next, fast = fast.next);
        return slow;
    }
}