input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

steps = input[0].split("").map { _1 == "R" ? 1 : 0 }
map = input.map { _1.scan(/\p{Word}+/) }.to_h { |key, *vals| [key, vals] }

loc = "AAA"
result = steps.cycle.take_while { loc = map[loc][steps[_1]]; loc != "ZZZ"}.size + 1

pp result