orders, updates = File.read(File.join(File.dirname(__FILE__), "input.txt")).split("\n\n")
order_map = orders.split("\n").each_with_object(Hash.new([])) do |order, map| 
  order.split("|").then { map[_2] += [_1] }
end

result = updates.split("\n").map { _1.split(",") }.select do |update|
  (0...update.size).all? { |idx| (order_map[update[idx]].intersection(update) - update[0...idx]).empty? }
end.sum { _1[_1.size / 2].to_i }

puts result