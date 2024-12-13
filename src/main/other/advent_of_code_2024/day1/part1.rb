left, right = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .map(&:chomp)
  .map { |line| line.split("   ") }
  .transpose
  .map(&:sort)

result = left.zip(right).sum { (_1.to_i - _2.to_i).abs }

pp result
