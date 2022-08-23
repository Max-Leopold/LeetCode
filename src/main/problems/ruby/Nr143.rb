# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} head
# @return {Void} Do not return anything, modify head in-place instead.
def reorder_list(head)
    slow = head
    fast = head
    length = 0
    stack = []

    while fast
        stack.push(slow)

        slow = slow.next
        length += 1
        length += 1 if fast.next
        fast = fast.next&.next
    end

    right_part = slow
    stack.last.next = nil
    stack.pop if length % 2 != 0

    while !stack.empty?
        top = stack.pop
        top_next = top.next
        right_part_next = right_part.next
        top.next = right_part
        right_part.next = top_next
        right_part = right_part_next
    end
    head
end