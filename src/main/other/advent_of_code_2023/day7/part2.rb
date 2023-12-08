input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map{ _1.split(" ") }
values = { "A" => "Z", "K" => "Y", "Q" => "X", "J" => "0", "T" => "V"}

result = input.map do |hand, bit|
    counts = hand.split("").tally
    jokers = counts.delete("J").to_i

    sorted = counts.values.sort.reverse
    sorted[0] = (sorted[0] || 0) + jokers
    [
        sorted + [hand.split("").map { |c| values[c] || c }],
        bit.to_i
    ]
end.sort_by { _1.first }.map.each_with_index { |arr, i| arr[1].to_i * (i + 1) }.sum

pp result