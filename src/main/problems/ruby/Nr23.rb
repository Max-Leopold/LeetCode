# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode[]} lists
# @return {ListNode}
def merge_k_lists(lists)
    return lists if lists.size == 0
    return lists[1] if lists.size == 1
    
    merge_lists(lists, 0, lists.size - 1)
end

def merge_lists(lists, first, last)
    return lists[first] if first == last
    return merge_two_lists(lists[first], lists[last]) if last - first == 1

    pivot = (first +  last) / 2
    return merge_two_lists(
        merge_lists(lists, first, pivot),
        merge_lists(lists, pivot + 1, last)
    )
end

def merge_two_lists(list1, list2)
    return list2 unless list1
    return list1 unless list2

    if list1.val < list2.val
        list1.next = merge_two_lists(list1.next, list2)
        list1
    else
        list2.next = merge_two_lists(list1, list2.next)
        list2
    end
end