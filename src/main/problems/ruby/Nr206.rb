
# Definition for singly-linked list.
class ListNode
    attr_accessor :val, :next
    def initialize(val = 0, _next = nil)
        @val = val
        @next = _next
    end
end
# @param {ListNode} head
# @return {ListNode}
def reverse_list(head)
  prev = nil
  next_node = head

  while next_node
    next_node, next_node.next, prev = next_node.next, prev, next_node
  end
  prev
end

a = ListNode.new(1)
b = ListNode.new(2)
c = ListNode.new(3)
d = ListNode.new(4)
e = ListNode.new(5)

a.next = b
b.next = c
c.next = d
d.next = e

puts reverse_list(a).val