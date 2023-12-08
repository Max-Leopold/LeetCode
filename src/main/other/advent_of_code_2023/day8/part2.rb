input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

steps = input[0].split("").map { _1 == "R" ? 1 : 0 }
map = input[2..].map { _1.scan(/\p{Word}+/) }.to_h { |key, *vals| [key, vals]}

result = map.keys.select { _1.end_with? "A" }.map do |loc|
    steps.cycle.take_while { loc = map[loc][steps[_1]]; !loc.end_with? "Z" }.size + 1
end.reduce(&:lcm)

pp result
