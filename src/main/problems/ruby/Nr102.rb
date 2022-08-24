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
# @return {Integer[][]}
def level_order(root, levels = [], level = 0)
    return [] unless root

    levels << [] unless levels[level]
    levels[level] << root.val
    level_order(root.left, levels, level + 1)
    level_order(root.right, levels, level + 1)
    levels
end