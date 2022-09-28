# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} head
# @param {Integer} n
# @return {ListNode}
def remove_nth_from_end(head, n)
    dummy_head = ListNode.new(-1, head)

    fast = dummy_head
    n.times { fast = fast.next }
    slow = dummy_head

    while fast.next
        fast = fast.next
        slow = slow.next
    end

    slow.next = slow.next.next
    dummy_head.next
end