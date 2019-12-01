package solutions;

import classes.ListNode;
import util.Utils;

public class Nr21 {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null) {
      return l2;
    }

    if(l2 == null) {
      return l1;
    }
    ListNode newList;

    if(l1.val < l2.val) {
      newList = l1;

      l1 = l1.next;
    } else {
      newList = l2;
      l2 = l2.next;
    }

    ListNode head = newList;

    while (l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        newList.next = l1;
        newList = newList.next;
        l1 = l1.next;
      } else {
        newList.next = l2;
        newList = newList.next;
        l2 = l2.next;
      }
    }

    if(l1 == null){
      newList.next = l2;
    } else {
      newList.next = l1;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode one = Utils.stringToListNode("[1,2,3]");
    ListNode two = Utils.stringToListNode("[1,3,4]");

    System.out.println(Utils.listNodeToString(mergeTwoLists(one, two)));
  }
}
