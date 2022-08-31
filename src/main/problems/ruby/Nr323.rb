# @param {Integer} n
# @param {Integer[][]} edges
# @return {Integer}
def count_components(n, edges)
    graph = edges.each_with_object({}) { |(k, v), h| (h[k] ||= []) << v; (h[v] ||= []) << k }
    visited = []
    count = 0
    (0...n).each do |node|
        unless visited[node]
            count += 1
            mark(node, visited, graph)
        end
    end

    count
end

def mark(node, visited, graph)
    return if visited[node]

    visited[node] = true
    graph[node]&.each { |new_node| mark(new_node, visited, graph) }
end

puts count_components(5, [[0,1], [1,2], [3,4]])