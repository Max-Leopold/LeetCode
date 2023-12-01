input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

numbers = %w(zero one two three four five six seven eight nine 0 1 2 3 4 5 6 7 8 9)

def find_leftmost_number(string, numbers)
    numbers.each_with_index.map do |number, index|
        idx = string.index(number)
        [idx, (index % 10).to_s] if idx
    end.compact.min_by{_1}.last
end

result = input.map do |line|
    left = find_leftmost_number(line, numbers)
    right = find_leftmost_number(line.reverse, numbers.map(&:reverse))
    (left + right).to_i
end.sum

pp result