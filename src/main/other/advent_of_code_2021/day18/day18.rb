require_relative 'list_node'
require_relative 'linked_leaf_tree'

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

tree = LinkedLeafTree.from_string(input.readline)
input.each {|line|
    summand = LinkedLeafTree.from_string(line)
    sum_tree = LinkedLeafTree.from_subtrees(tree, LinkedLeafTree.from_string(line))
    sum_tree.reduce
    tree = sum_tree
}

puts "Day 18, Part 1: After summing all numbers, the final snailfish number has a magnitude of #{tree.magnitude}"

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
trees = input.map {|line| LinkedLeafTree.from_string(line)}
tree_pairs = trees.permutation(2).to_a

tree_pairs = tree_pairs.map {|tree1, tree2| 
    sum_tree = LinkedLeafTree.from_subtrees(tree1, tree2)
    sum_tree.reduce.magnitude
}

puts "Day 18, Part 2: Max magnitude after adding any two snailfish numbers from the input: #{tree_pairs.max}"