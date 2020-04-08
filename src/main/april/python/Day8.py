class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None


class Solution:
	def middleNode(self, head: ListNode) -> ListNode:
		slow = head
		fast = head
		while fast is not None:
			fast = fast.next
			if fast is not None:
				fast = fast.next
				slow = slow.next

		return slow
