map = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .map { it.chomp.chars }

directions = [-1, 1, 0].repeated_permutation(2).reject { it == [0, 0] }

result = map.each_with_index.sum do |line, row_num|
  line.each_with_index.count do |char, column_num|
    char == "@" && directions.count do |(x, y)|
      row_num + x >= 0 && column_num + y >= 0 && map.dig(row_num + x, column_num + y) == "@"
    end < 4
  end
end

pp result