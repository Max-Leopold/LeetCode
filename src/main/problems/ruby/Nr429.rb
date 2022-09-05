# Definition for a Node.
# class Node
#     attr_accessor :val, :children
#     def initialize(val)
#         @val = val
#         @children = []
#     end
# end

# @param {Node} root
# @return {List[List[int]]}
def level_order(root, levels = [], depth = 0)
    levels[depth] ||= []
    levels[depth] << root.val
    root.children.each { |child| level_order(child, levels, depth + 1) }
    levels
end