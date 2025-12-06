result = File.readlines(File.join(File.join(File.dirname(__FILE__), "input.txt")), chomp: true)
  .map { it.split("") }
  .transpose
  .each_with_object([[]]) { |elem, acc| elem.join.strip.empty? ? acc << [] : acc.last << elem }
  .sum do |nums|
    nums.map { |num| num.join.to_i }.reduce(&nums.first.last.to_sym)
  end

pp result
