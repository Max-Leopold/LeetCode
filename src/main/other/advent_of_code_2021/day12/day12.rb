require 'set'

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

class Cave

    attr_reader :start, :end, :big, :edges, :name

    def initialize(name)
        @name = name
        @start = name == :start ? true : false
        @end = name == :end ? true : false
        @big = name == name.upcase ? true : false
        @edges = []
    end

    def add_edge(edge)
        @edges << edge
    end

    def to_s
        "Name: #{@name}, Start: #{@start}, End: #{@end}, Big: #{@big}, Edges: #{@edges.map(&:name)}"
    end
end

def create_graph(input)
    graph = {}
    input.each {|edge|
        node1, node2 = edge.split("-").map(&:chomp).map(&:to_sym).map do |node_sym|
            graph[node_sym] = graph.fetch(node_sym, Cave.new(node_sym))
        end
        node1.add_edge node2
        node2.add_edge node1
    }
    graph
end

def paths_from_to(start_point, end_point, visited=Set.new)
    # Reached end
    return 1 if start_point == end_point

    visited << start_point
    # Try all other edges
    paths = start_point.edges.map do |edge|
        paths_from_to(edge, end_point, visited) if !visited.include?(edge) || edge.big
    end.reject(&:nil?).sum
    visited.delete(start_point)
    return paths
end

def paths_from_to_part2(start_point, end_point, visited_cave_twice=nil, visited=Set.new)
    # Reached end
    return 1 if start_point == end_point

    visited << start_point unless start_point.big
    # Try all other edges
    paths = start_point.edges.map do |edge|
        if !visited.include?(edge)
            paths_from_to_part2(edge, end_point, visited_cave_twice, visited)
        elsif !visited_cave_twice && edge.name != :start
            paths_from_to_part2(edge, end_point, edge, visited)
        end
    end.reject(&:nil?).sum
    visited.delete(start_point) unless visited_cave_twice == start_point
    return paths
end

graph = create_graph input

paths = paths_from_to(graph[:start], graph[:end])
puts paths
paths = paths_from_to_part2(graph[:start], graph[:end])
puts paths