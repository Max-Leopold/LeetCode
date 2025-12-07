file = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).map(&:chars)
splitter = file.map { |row| row.each_index.select { |index| row[index] == "^" }.to_set }

result = splitter.reduce([[file.first.find_index("S"), 1]]) do |positions, splitter|
  positions
    .flat_map { |(pos, count)| splitter === pos ? [[pos + 1, count], [pos - 1, count]] : [[pos, count]] }
    .group_by(&:first)
    .map { |pos, orig| [pos, orig.map(&:last).sum] }
end.sum(&:last)

pp result