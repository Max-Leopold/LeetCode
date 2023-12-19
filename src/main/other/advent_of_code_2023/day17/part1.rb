require "Set"
require "algorithms"

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars).map { _1.map(&:to_i) }
dirs, end_pos = [Complex(0, 1), Complex(0, -1), Complex(1, 0), Complex(-1, 0)], Complex(input.first.size - 1, input.size - 1)
min_heap, v = Containers::MinHeap.new, Set.new

min_heap.push(0, [0, Complex(0, 0), Complex(0, 1)])
min_heap.push(0, [0, Complex(0, 0), Complex(1, 0)])
res = until min_heap.empty?
    cost, pos, dir = min_heap.pop
    next if v.include?([pos, dir])
    break cost if pos == end_pos
    v.add([pos, dir])
    dirs.reject { _1 == dir || _1 + dir == Complex(0, 0) }.each do |new_dir|
        (1..3).each do |steps|
            new_pos = pos + new_dir * steps
            new_costs = cost + input[Range.new(*[pos.imaginary, new_pos.imaginary].minmax)].map { |row| row[Range.new(*[pos.real, new_pos.real].minmax)]}.flatten.sum - input[pos.imaginary][pos.real]
            entry = [new_costs, new_pos, new_dir]
            if new_pos.imaginary.between?(0, input.size - 1) && new_pos.real.between?(0, input.first.size - 1) && !v.include?(entry.last(2))
                min_heap.push(entry.first, entry)
            end
        end
    end
end

pp res