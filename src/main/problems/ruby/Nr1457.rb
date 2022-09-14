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
# @return {Integer}
def pseudo_palindromic_paths(root, arr = Array.new(10) { 0 })
    return 0 unless root

    arr[root.val] += 1
    res = if root.left == nil && root.right == nil
        is_palindromic?(arr) ? 1 : 0
    else
        pseudo_palindromic_paths(root.left, arr) + pseudo_palindromic_paths(root.right, arr)
    end
    arr[root.val] -= 1

    res
end

def is_palindromic?(arr)
    arr.select { |x| x % 2 != 0 }.size <= 1
end