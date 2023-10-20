// @algorithm @lc id=100188 lang=java 
// @title sum-lists-lcci
package _____02_05_Sum_Lists_LCCI;
// @test([7,1,6],[5,9,2])=[2,1,9]
import algm.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode dummy = new ListNode(), pointer = dummy;
        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(sum % 10);
            sum /= 10;
            pointer = pointer.next;
        }
        return dummy.next;
    }
}