// @algorithm @lc id=1000008 lang=java 
// @title partition-list-lcci
package _____02_04_Partition_List_LCCI;
import algm.*;
// @test([3,5,8,5,10,2,1],5)=[3,2,1,5,8,5,10]
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(), rightDummy = new ListNode();
        ListNode leftPointer = leftDummy, rightPointer = rightDummy;
        for (ListNode pointer = head; pointer != null; pointer = pointer.next) {
            if (pointer.val < x) {
                leftPointer.next = pointer;
                leftPointer = leftPointer.next;
            } else {
                rightPointer.next = pointer;
                rightPointer = rightPointer.next;
            }
        }
        leftPointer.next = rightDummy.next;
        rightPointer.next = null;
        return leftDummy.next;
    }
}