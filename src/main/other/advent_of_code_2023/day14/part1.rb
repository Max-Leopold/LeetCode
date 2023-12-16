input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)

res = input.transpose.reverse.sum do |line|
    l = 0
    line.each_with_index do |elem, r|
        line[l], line[r] = line[r], line[l] if elem == "O"
        l = r + 1 if elem == "#"
        l += 1 while line[l] != "." && l < r
    end
    line.map.with_index { _1 == "O" ? line.size - _2 : 0 }.sum
end

pp res