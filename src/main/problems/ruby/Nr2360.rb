require 'set'

# @param {Integer[]} edges
# @return {Integer}
def longest_cycle(edges)
    longest_cycle = -1
    grey_set_stack = []
    grey_set = Set.new
    i = 0
    for i in 0...edges.size
        next if edges[i] == -1

        # Search
        curr_node = i
        while edges[curr_node] != -1
            # Found cycle
            if grey_set.include?(curr_node)
                # Calculate size
                size = 1
                while grey_set_stack.last != curr_node
                    edges[grey_set_stack.pop] = -1
                    size += 1
                end
                longest_cycle = [longest_cycle, size].max
            end

            grey_set_stack << curr_node
            grey_set << curr_node
            curr_node = edges[curr_node]
        end

        # Mark nodes
        while !grey_set_stack.empty?
            edges[grey_set_stack.pop] = -1
        end
        grey_set = Set.new
    end

    longest_cycle
end