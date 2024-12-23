def check_operators(target, result, operands)
  return target == result if operands.empty?
  return [:+, :*].any? { check_operators(target, result.send(_1, operands[0]), operands[1..]) } 
end

result = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).sum do |line|
  target, operands = line.split(": ").then { |target, operands| [target.to_i, operands.split(" ").map(&:to_i)] }
  check_operators(target, operands[0], operands[1...]) ? target : 0
end

pp result