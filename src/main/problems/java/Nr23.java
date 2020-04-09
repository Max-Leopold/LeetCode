package main.problems.java;

import main.util.java.ListNode;

public class Nr23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		for (int i = 1; i < lists.length; i++) {
			lists[0] = mergeTwoLists(lists[0], lists[i]);
		}

		return lists[0];
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		l2.next = mergeTwoLists(l1, l2.next);
		return l2;
	}
}
