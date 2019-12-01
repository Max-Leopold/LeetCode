package solutions;

import classes.ListNode;
import util.Utils;

public class Nr203 {

  public static ListNode removeElements(ListNode head, int val) {

    while(head != null && head.val == val) {
      if(head.next == null) {
        return null;
      }
      head = head.next;
    }

    if(head == null) {
      return null;
    }

    ListNode currentNode = head;
    while(currentNode.next != null) {
      if(currentNode.next.val == val) {
        currentNode.next = currentNode.next.next;
      } else {
        currentNode = currentNode.next;
      }

    }

    return head;
  }


  public static void main(String[] args) {
    ListNode head = Utils.stringToListNode("[1,2,2,1]");

    removeElements(head, 2);

    System.out.println(Utils.listNodeToString(head));
  }
}
