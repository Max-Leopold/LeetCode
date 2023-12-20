require "ruby-graphviz"

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

graph = GraphViz.new(:G, type: :digraph)
modules = input.each do |line|
    name, dests = line.split(" -> ")
    dests.split(",").map(&:strip).each { graph.add_edges(name[1..], _1) }
end

graph.output(png: "graph.png") 