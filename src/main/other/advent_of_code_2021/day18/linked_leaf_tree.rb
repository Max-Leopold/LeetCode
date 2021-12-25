class LinkedLeafTree
    
    attr_accessor :left, :right, :parent, :list_head

    def magnitude
        left_magnitude = left.is_a?(LinkedLeafTree) ? left.magnitude : left.value
        right_magnitude = right.is_a?(LinkedLeafTree) ? right.magnitude : right.value

        3 * left_magnitude + 2 * right_magnitude
    end

    def reduce
        explode
        while true
            split_found = split
            break unless split_found
            explode
        end
        self
    end

    def self.from_subtrees(left, right)
        left = Marshal.load(Marshal.dump(left))
        right = Marshal.load(Marshal.dump(right))

        new_root = LinkedLeafTree.new
        new_root.left = left
        new_root.right = right
        new_root.list_head = left.list_head

        left.parent = new_root
        right.parent = new_root
        right.list_head.prev = left.list_end
        left.list_end.next = right.list_head
        new_root.list_head.each {|list_node| list_node.depth += 1}

        new_root
    end

    def self.from_string(string)
        root_dummy = LinkedLeafTree.new
        current_node = root_dummy

        list_dummy = ListNode.new
        prev = list_dummy
        depth = -1

        set_y = false
    
        string.chomp.split("").each {|char|
            case char
            when "["
                if set_y
                    current_node.right = LinkedLeafTree.new
                    current_node.right.parent = current_node
                    current_node = current_node.right
                else
                    current_node.left = LinkedLeafTree.new
                    current_node.left.parent = current_node
                    current_node = current_node.left
                end
                depth += 1
                set_y = false
            when "]"
                current_node = current_node.parent
                depth -= 1
            when ","
                set_y = true
            else
                list_node = ListNode.new
                list_node.value = char.to_i
                list_node.prev = prev
                list_node.depth = depth
                list_node.parent = current_node
                prev.next = list_node unless prev.nil?
                prev = list_node
                if set_y
                    current_node.right = list_node
                else
                    current_node.left = list_node
                end
                set_y = false
            end
        }
        root = root_dummy.left
        root.parent = nil

        root.list_head = list_dummy.next
        root.list_head.prev = nil

        root
    end

    def list_end
        list_end = list_head
        while !list_end.next.nil?; list_end = list_end.next; end
        list_end
    end

    def to_s
        "[#{left},#{right}]"
    end

    private 

    def explode(list_node=@list_head)
        if !list_node.prev.nil?
            if list_node.depth == 4
                if list_node.prev.parent == list_node.parent
                    left_pair_value = list_node.prev
                    right_pair_value = list_node

                    left_summand = left_pair_value.prev
                    right_summand = right_pair_value.next

                    new_list_node = ListNode.new
                    new_list_node.value = 0
                    new_list_node.depth = list_node.depth - 1
                    new_list_node.next = right_summand
                    new_list_node.prev = left_summand


                    new_list_node.next.value += right_pair_value.value unless new_list_node.next.nil?
                    new_list_node.prev.value += left_pair_value.value unless new_list_node.prev.nil?
                    new_list_node.prev.next = new_list_node unless new_list_node.prev.nil?
                    new_list_node.next.prev = new_list_node unless new_list_node.next.nil?

                    # Set parents
                    list_node.parent.parent.left = new_list_node if list_node.parent.parent.left == list_node.parent
                    list_node.parent.parent.right = new_list_node if list_node.parent.parent.right == list_node.parent
                    new_list_node.parent = list_node.parent.parent

                    self.list_head = new_list_node if self.list_head == left_pair_value
                end
            end
        end

        if !list_node.next.nil?
            explode list_node.next
        end
    end

    def split(list_node=@list_head)
        if list_node.value > 9
            linked_leaf_tree = LinkedLeafTree.new

            left_leaf = ListNode.new
            left_leaf.value = (list_node.value.to_f / 2).floor
            left_leaf.depth = list_node.depth + 1
            left_leaf.parent = linked_leaf_tree

            right_leaf = ListNode.new
            right_leaf.value = (list_node.value.to_f / 2).ceil
            right_leaf.depth = list_node.depth + 1
            right_leaf.parent = linked_leaf_tree

            left_leaf.next = right_leaf
            left_leaf.prev = list_node.prev
            right_leaf.prev = left_leaf
            right_leaf.next = list_node.next

            list_node.prev.next = left_leaf unless list_node.prev.nil?
            list_node.next.prev = right_leaf unless list_node.next.nil?

            linked_leaf_tree.left = left_leaf
            linked_leaf_tree.right = right_leaf
            linked_leaf_tree.parent = list_node.parent
            list_node.parent.left = linked_leaf_tree if list_node.parent.left == list_node
            list_node.parent.right = linked_leaf_tree if list_node.parent.right == list_node

            self.list_head = left_leaf if list_node == self.list_head

            return true
        elsif !list_node.next.nil?
            return split(list_node.next)
        end
        return false
    end
end