# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} head
# @return {Integer[]}
def next_larger_nodes(head)
  list_size = list_size(head)
  res = Array.new(list_size) { 0 }
  stack = []
  for idx in 0...list_size
    while !stack.empty? && head.val > stack.last[0]
      res[stack.pop[1]] = head.val
    end
    stack << [head.val, idx]
    head = head.next
  end

  res
end

def list_size(head)
  size = 0
  while head
    size += 1
    head = head.next
  end
  size
end
