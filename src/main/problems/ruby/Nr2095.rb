# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} head
# @return {ListNode}
def delete_middle(head)
  dummy = ListNode.new(-1, head)
  slow = dummy
  fast = head
  while fast&.next
    fast = fast.next.next
    slow = slow.next
  end

  slow.next = slow.next.next
  dummy.next
end
