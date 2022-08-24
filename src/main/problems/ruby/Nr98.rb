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
# @return {Boolean}
def is_valid_bst(root, min = nil, max = nil)
    return true unless root

    return false if root.val <= max if max
    return false if root.val >= min if min

    is_valid_bst(root.left, root.val, max) && is_valid_bst(root.right, min, root.val)
end