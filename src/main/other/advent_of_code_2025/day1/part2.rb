result = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .reduce([50, 0]) do |(pos, count), instruction|
    pos = instruction[0] == 'L' ? pos - instruction[1..].to_i : pos + instruction[1..].to_i
    count += (pos / 100).abs
    pos %= 100
    [pos, count]
  end.last

puts result