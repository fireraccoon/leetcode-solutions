package utils;

/**
 * Utils for converting the data.
 */
public class ConvertUtils {
    /**
     * Convert an array to a LinkedList.
     * @param array
     * @return {@code linkedlist}
     */
    public static ListNode toLinkedList(int[] array) {
        ListNode ans = new ListNode(), pointer = ans;
        for (int num : array) {
            pointer.next = new ListNode(num);
            pointer = pointer.next;
        }
        return ans.next;
    }
}
