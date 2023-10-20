package utils;

import java.util.Arrays;

/**
 * Utils for showing the data.
 */
public class DisplayUtils {
    /**
     * Display a table.
     * @param table
     */
    public static void display(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.println(Arrays.toString(table[i]));
        }
    }

    /**
     * Display a linkedlist.
     * @param head
     */
    public static void display(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val + ",");
            head = head.next;
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.append(']').toString());
    }
}
