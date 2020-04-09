package main.problems.java;

import main.util.java.ListNode;

public class Nr25 {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(5);
		ListNode listNode5 = new ListNode(6);

		listNode.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;

		Nr25 nr25 = new Nr25();

		ListNode reversed = nr25.reverseKGroup(listNode, 3);
		while (reversed != null) {
			System.out.println(reversed.val);
			reversed = reversed.next;
		}

	}

	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode returnHead = head;
		ListNode thisEnd = moveHeadKSteps(head, k - 1);
		ListNode thisStart = head;
		ListNode nextStart = moveHeadKSteps(head, k);
		if (thisEnd != null) {
			returnHead = reverse(null, thisStart, 0, k);
		}
		ListNode lastEnd = thisStart;

		thisStart = nextStart;
		ListNode longEnough = moveHeadKSteps(thisStart, k - 1);
		while (thisStart != null && longEnough != null) {
			nextStart = moveHeadKSteps(nextStart, k);
			thisEnd = thisStart;
			ListNode n = reverse(null, thisStart, 0, k);
			lastEnd.next = n;
			lastEnd = thisEnd;
			thisStart = nextStart;
			longEnough = moveHeadKSteps(thisStart, k - 1);
		}
		if (thisStart != null) {
			lastEnd.next = thisStart;
		}

		return returnHead;
	}

	public ListNode moveHeadKSteps(ListNode head, int k) {
		for (int i = 0; i < k; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		return head;
	}

	public ListNode reverse(ListNode prev, ListNode now, int i, int max) {
		/**
		 * if(now == null) {
		 * 	return prev;
		 * }
		 */
		if (i == max) {
			return prev;
		}

		ListNode formerNext = now.next;
		now.next = prev;
		return reverse(now, formerNext, i + 1, max);
	}
}
