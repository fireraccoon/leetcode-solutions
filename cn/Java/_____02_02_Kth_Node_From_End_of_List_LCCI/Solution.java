// @algorithm @lc id=1000007 lang=java 
// @title kth-node-from-end-of-list-lcci
package _____02_02_Kth_Node_From_End_of_List_LCCI;
// @test([1,2,3,4],2)=3
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
    public int kthToLast(ListNode head, int k) {
        ListNode preKNode = head;
        for (int i = 0; head != null; head = head.next, i++) {
            if (i >= k) {
                preKNode = preKNode.next;
            }
        }
        return preKNode.val;
    }
}