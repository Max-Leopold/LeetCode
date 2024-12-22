orders, updates = File.read(File.join(File.dirname(__FILE__), "input.txt")).split("\n\n")
ORDER_MAP = orders.split("\n").each_with_object(Hash.new([])) do |order, map| 
  order.split("|").then { map[_2] += [_1] }
end

def valid_update?(update, remaining = [])
  (0...update.size).all? { |idx| (ORDER_MAP[update[idx]].intersection(update + remaining) - update[0...idx]).empty? }
end

def construct_update(current, remaining)
  return current if remaining.empty?
  next_valid = remaining.find { valid_update?(current + [_1], remaining) }
  construct_update(current << next_valid, remaining - [next_valid])
end

result = updates.split("\n").map { _1.split(",") }.sum do |update|
  valid_update?(update) ? 0 : construct_update([], update)[update.size / 2].to_i
end

puts result