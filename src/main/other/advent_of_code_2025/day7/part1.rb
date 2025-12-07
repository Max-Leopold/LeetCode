file = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).map(&:chars)
splitter = file.map { |row| row.each_index.select { |index| row[index] == "^" } }

result = splitter.reduce([[file.first.find_index("S")], 0]) do |(pos, splits), splitter|
  new_pos = splitter.intersection(pos).flat_map { |splitter_pos| [splitter_pos + 1, splitter_pos - 1] }
  [((pos - splitter).union(new_pos)), splits + new_pos.size / 2]
end.last

pp result