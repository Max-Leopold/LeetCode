package solutions;

import classes.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */

public class Nr19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) {
      return null;
    }


    ListNode isMaybeEndNode = head;

    for(int i = 0; i < n; i++){
      isMaybeEndNode = isMaybeEndNode.next;
    }

    ListNode beforeDelete = null;

    while(isMaybeEndNode != null) {
      if(beforeDelete == null) {
        beforeDelete = head;
      } else {
        beforeDelete = beforeDelete.next;
      }
      isMaybeEndNode = isMaybeEndNode.next;
    }

    if(beforeDelete == null) {
      return head.next;
    }

    if(beforeDelete.next.next == null) {
      beforeDelete.next = null;
      return head;
    }


    beforeDelete.next = beforeDelete.next.next;
    return head;
  }

}
