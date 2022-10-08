# Definition for Node.
# class Node
#     attr_accessor :val, :next, :random
#     def initialize(val = 0)
#         @val = val
#		  @next = nil
#		  @random = nil
#     end
# end

# @param {Node} node
# @return {Node}
def copyRandomList(head)
  oldHead = head
  mapping = {}

  while head
    mapping[head] = Node.new(head.val)
    head = head.next
  end

  head = oldHead
  newHead = Node.new(-1)
  current = newHead

  while head
    current.next = mapping[head]
    current.next.random = mapping[head.random] if head.random

    current = current.next
    head = head.next
  end

  newHead.next
end
