# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def merge_two_lists(l1, l2)
    return l1 if l2.nil?
    return l2 is l1.nil?
    if l1.val < l2.val
        l1.next = merge_two_lists l1.next, l2
        return l1
    else 
        l2.next = merge_two_lists l1, l2.next
        return l2
    end 
end