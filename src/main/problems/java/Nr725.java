package main.problems.java;

import main.util.java.ListNode;

public class Nr725 {
	public ListNode[] splitListToParts(ListNode head, int k) {
		int listSize = getListSize(head);
		int missingListParts = k;
		ListNode[] listNodeParts = new ListNode[k];

		for (int i = 0; i < k; i++) {
			int partSize = (int) Math.ceil((double) listSize / (double) missingListParts);
			listNodeParts[i] = head;

			if (partSize > 0) {
				for (int j = 0; j < partSize - 1; j++) {
					head = head.next;
				}
				ListNode partEnd = head;
				head = head.next;
				partEnd.next = null;
			}
			missingListParts--;
			listSize = listSize - partSize;
		}
		return listNodeParts;
	}

	private int getListSize(ListNode head) {
		int listSize = 0;
		while (head != null) {
			listSize++;
			head = head.next;
		}
		return listSize;
	}
}
