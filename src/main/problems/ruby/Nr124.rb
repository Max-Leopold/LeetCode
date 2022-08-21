# Definition for a binary tree node.
class TreeNode
    attr_accessor :val, :left, :right
    def initialize(val = 0, left = nil, right = nil)
        @val = val
        @left = left
        @right = right
    end
end

def max_path_sum(root)
    max, _ = helper(root)
    max
end

# @param {TreeNode} root
# @return {Integer}
def helper(root)
    return -1001, 0 unless root

    left_max, left_one = helper(root.left)
    right_max, right_one = helper(root.right)

    using_both_subtrees = left_one + right_one + root.val
    using_one_subtree = [[left_one, right_one].max + root.val, root.val].max

    max = [
        left_max,
        right_max,
        using_both_subtrees,
        using_one_subtree,
        root.val
    ].max

    # puts "Node #{root.val}, Max #{max}, Using One #{using_one_subtree}"

    return max, using_one_subtree
end

# root = TreeNode.new(
#     -10,
#     TreeNode.new(-9, nil, nil),
#     TreeNode.new(
#         20,
#         TreeNode.new(15, nil, nil),
#         TreeNode.new(7, nil, nil)
#     )
# )
root = TreeNode.new(9, 
    TreeNode.new(6, nil, nil),
    TreeNode.new(-3, 
        TreeNode.new(-6, nil, nil), 
        TreeNode.new(2,
            TreeNode.new(2, 
                TreeNode.new(-6),
                TreeNode.new(-6)
            ),
            nil
        )
    )
)

puts max_path_sum(root)