package main.util.java;

public class ListNodeBuilder {

    public static ListNode buildList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode previous = head;
        for (int i = 1; i < values.length; i++) {
            ListNode next = new ListNode(values[i]);
            previous.next = next;
            previous = next;
        }

        return head;
    }
}
