# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {Integer[]} preorder
# @param {Integer[]} inorder
# @return {TreeNode}

def build_tree(preorder, inorder)
    @pre_index = 0
    helper(preorder, inorder, @pre_index, 0, inorder.size)
end

def helper(preorder, inorder, pre, in_start, in_end)
    return nil if in_start > in_end
    return nil if pre >= preorder.size

    root_val = preorder[pre]
    root = TreeNode.new(root_val)

    in_index = inorder.find_index(root_val)
    @pre_index += 1
    root.left = helper(preorder, inorder, @pre_index, in_start, in_index - 1)
    root.right = helper(preorder, inorder, @pre_index, in_index + 1, in_end)
    root
end