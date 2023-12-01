input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map { |line| line.split("") }

solution = input.map do |line|
    first = line.find { |num| num.to_i.to_s == num }
    last = line.reverse.find { |num| num.to_i.to_s == num }

    (first + last).to_i
end.sum

puts solution