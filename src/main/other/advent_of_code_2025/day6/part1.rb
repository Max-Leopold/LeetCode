result = File.readlines(File.join(File.join(File.dirname(__FILE__), "input.txt")), chomp: true)
  .map { it.split(/\s+/) }
  .transpose
  .sum { |*numbers, operator| numbers.map(&:to_i).reduce(&operator.to_sym) }

pp result
