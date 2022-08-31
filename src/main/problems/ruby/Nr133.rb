# Definition for a Node.
# class Node
#     attr_accessor :val, :neighbors
#     def initialize(val = 0, neighbors = nil)
#         @val = val
#         neighbors = [] if neighbors.nil?
#         @neighbors = neighbors
#     end
# end

require 'set'

# @param {Node} node
# @return {Node}
def cloneGraph(node)
    return unless node
    
    queue = [node]
    nodes = {}
    root = nil

    while !queue.empty?
        top = queue.shift

        # Clone
        nodes[top.val] ||= Node.new(top.val)
        top.neighbors.each do |neighbor|
            # Get or create neighbor
            unless nodes[neighbor.val]
                nodes[neighbor.val] = Node.new(neighbor.val)
                queue << neighbor
            end

            nodes[top.val].neighbors << nodes[neighbor.val]
        end

        root ||= nodes[top.val]
    end

    root
end

