/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

import utils.ListNode;

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int[] buffer = toArray(head);
        return isPalindrome(buffer);
    }
    boolean isPalindrome(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    int sizeOf(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }
    int[] toArray(ListNode head) {
        int n = sizeOf(head);
        int[] buffer = new int[n];
        for (int i = 0; i < n; i++) {
            buffer[i] = head.val;
            head = head.next;
        }
        return buffer;
    }
}
// @lc code=end

