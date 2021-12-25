require_relative 'alu'

instructions = File.open(File.join(File.dirname(__FILE__), "input.txt")).to_a

puts "Check model number 93959993429899 - z is #{Alu.monad(instructions, 93959993429899)["z"].value}"
puts "Day 24, Part 1: The largest model number accepted by monad is 93959993429899"
puts "Check model number 11815671117121 - z is #{Alu.monad(instructions, 11815671117121)["z"].value}"
puts "Day 24, Part 2: The smallest model number accepted by monad is 11815671117121"
