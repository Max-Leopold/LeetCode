map = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .map { it.chomp.chars }

directions = [-1, 1, 0].repeated_permutation(2).reject { it == [0, 0] }
positions_to_check = map.each_index.to_a.product(map.first.each_index.to_a)
removed = 0

until positions_to_check.empty?
  row_num, column_num = positions_to_check.pop

  surrounding_positions = directions.filter_map do |(x, y)|
    [row_num + x, column_num + y] if row_num + x >= 0 && column_num + y >= 0 && map.dig(row_num + x, column_num + y)
  end
  if map.dig(row_num, column_num) == "@" && surrounding_positions.count { map.dig(*_1) == "@" } < 4
    removed += 1
    positions_to_check += surrounding_positions
    map[row_num][column_num] = "."
  end
end

pp removed