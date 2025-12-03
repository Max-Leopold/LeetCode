result = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .map { it.chomp.chars }
  .map do |bank|
    first = bank[0...-1].each_with_index.max_by(&:first)
    second = bank[(first[1] + 1)..].max
    (first[0] + second).to_i
  end.sum

pp result