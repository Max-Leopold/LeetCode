# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {TreeNode} root
# @param {Integer} target_sum
# @return {Integer[][]}
def path_sum(root, target_sum, path = [])
  return [] unless root

  if root.right.nil? && root.left.nil?
    if target_sum - root.val == 0
      return [path.dup << root.val]
    else
      return []
    end
  end

  new_target_sum = target_sum - root.val
  path << root.val

  left_res = path_sum(root.left, new_target_sum, path)
  right_res = path_sum(root.right, new_target_sum, path)

  path.pop
  left_res + right_res
end
