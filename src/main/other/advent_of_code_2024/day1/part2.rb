require 'Set'

left, right = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .map(&:chomp)
  .map { |line| line.split("   ") }
  .transpose

left_set = Set.new(left) 
result = right.sum { left_set.include?(_1) ? _1.to_i : 0 }

pp result