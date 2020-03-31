package main.java.solutions;

import classes.ListNode;
import main.java.util.Utils;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

public class Nr2 {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int over = 0;
    String result = "";
    while(l1 != null && l2 != null) {
      int overNext = (l1.val + l2.val + over) / 10;
      int rest = l1.val + l2.val - 10 * overNext;

      result = result.concat(String.valueOf(rest + over));
      over = overNext;
      l1 = l1.next;
      l2 = l2.next;
    }

    if(l1 == null) {
      while (l2 != null) {
        int overNext = (l2.val + over) / 10;
        int rest = l2.val - 10 * overNext;
        result = result.concat(String.valueOf(rest + over));
        l2 = l2.next;
        over = overNext;
      }
    }

    if(l2 == null) {
      while (l1 != null) {
        int overNext = (l1.val + over) / 10;
        int rest = l1.val - 10 * overNext;
        result = result.concat(String.valueOf(rest + over));
        l1 = l1.next;
        over = overNext;
      }
    }

    if(over != 0) {
      result = result.concat(String.valueOf(over));
    }

    ListNode dummyHead = new ListNode(0);
    ListNode x = dummyHead;
    for (int i = 0; i < result.length(); i++) {
      x.next = new ListNode(Integer.parseInt(result.substring(i, i+1)));
      x = x.next;
    }

    return dummyHead.next;
  }

  public static void main(String[] args) {

    ListNode one = Utils.stringToListNode("[1]");
    ListNode two = Utils.stringToListNode("[9,9]");

    System.out.println(Utils.listNodeToString(addTwoNumbers(one, two)));
  }
}
