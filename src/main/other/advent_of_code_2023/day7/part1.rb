input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map{ _1.split(" ") }
values = { "A" => "Z", "K" => "Y", "Q" => "X", "J" => "W", "T" => "V"}

result = input.map do
    [
        _1[0].split("").tally.values.sort.reverse + [_1[0].split("").map { |c| values[c] || c }],
        _1[1].to_i
    ]
end.sort_by { _1.first }.map.each_with_index { |arr, i| arr[1].to_i * (i + 1) }.sum

pp result

