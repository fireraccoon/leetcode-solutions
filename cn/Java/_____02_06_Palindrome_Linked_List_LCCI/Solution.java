// @algorithm @lc id=100164 lang=java 
// @title palindrome-linked-list-lcci
package _____02_06_Palindrome_Linked_List_LCCI;
import algm.*;
// @test([1,2])=false
// @test([1,2,2,1])=true
// @test([1,0,1])=true
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode median = getMedian(head);
        ListNode reversedMedian = reverse(median.next);
        median.next = null;
        return equals(head, reversedMedian);
    }
    ListNode getMedian(ListNode head) {
        ListNode slow = head, fast = head;
        for (boolean isSlowIncreased = true; fast.next != null; isSlowIncreased = !isSlowIncreased) {
            if (!isSlowIncreased) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
    boolean equals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}