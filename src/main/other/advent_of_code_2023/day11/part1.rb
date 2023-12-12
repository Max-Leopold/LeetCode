input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

empty_rows = input.filter_map.with_index { _2 unless _1.include?("#")}
empty_cols = input.transpose.filter_map.with_index { _2 unless _1.include?("#") }
galaxies = input.flat_map.with_index { |line, y| line.filter_map.with_index { |c, x| [x, y] if c == "#" } }

res = galaxies.combination(2).map do |(x1, y1), (x2, y2)|
    manhatten = (x1 - x2).abs + (y1 - y2).abs
    manhatten + (empty_cols & Range.new(*[x1, x2].minmax).to_a).size + (empty_rows & Range.new(*[y1, y2].minmax).to_a).size
end.sum

pp res