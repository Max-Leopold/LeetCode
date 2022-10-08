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
def nodes_between_critical_points(head)
  res = [-1, -1]
  last_val = nil
  first_critical_point = nil
  last_critical_point = nil
  current_node = 1
  while head.next
    if last_val
      # Check is critical points
      if (head.val > last_val && head.val > head.next.val) ||
        (head.val < last_val && head.val < head.next.val)
        if first_critical_point
          res[1] = current_node - first_critical_point
        else
          first_critical_point = current_node
        end

        if last_critical_point
          res[0] =  current_node - last_critical_point if res[0] == -1
          res[0] = [res[0], current_node - last_critical_point].min
        end

        last_critical_point = current_node
      end
    end

    current_node += 1
    last_val = head.val
    head = head.next
  end

  res
end
