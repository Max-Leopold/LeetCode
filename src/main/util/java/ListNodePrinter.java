package main.util.java;

public class ListNodePrinter {

    public static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append("[");
            sb.append(head.val);
            sb.append("]");
            sb.append(" -> ");

            head = head.next;
        }
        sb.append("null");

        System.out.println(sb.toString());
    }
}
