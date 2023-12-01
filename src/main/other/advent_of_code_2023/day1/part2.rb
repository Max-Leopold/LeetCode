input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

numbers = %w(zero one two three four five six seven eight nine 0 1 2 3 4 5 6 7 8 9)

def find_leftmost_number(string, numbers)
    map = numbers.each_with_index.map do |number, value|
        idx = string.index(number)
        [idx, number] if idx
    end.compact.to_h

    (numbers.index(map[map.keys.min]) % 10).to_s
end

result = input.map do |line|
    left = find_leftmost_number(line, numbers)
    right = find_leftmost_number(line.reverse, numbers.map(&:reverse))
    (left + right).to_i
end.sum

pp result