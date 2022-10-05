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
# @param {Integer} val
# @param {Integer} depth
# @return {TreeNode}
def add_one_row(root, val, depth)
  dummy_root = TreeNode.new(val, root, nil)
  add_one_row_rec(dummy_root, val, depth)
  dummy_root.left
end

def add_one_row_rec(root, val, depth)
  return unless root

  if depth > 1
    add_one_row_rec(root.left, val, depth - 1)
    add_one_row_rec(root.right, val, depth - 1)
  else
    new_left = TreeNode.new(val, root.left, nil)
    new_right = TreeNode.new(val, nil, root.right)
    root.right, root.left = new_right, new_left
  end
end
