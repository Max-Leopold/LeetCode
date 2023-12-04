input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

copies = Array.new(input.size, 1)
res = input.each_with_index.sum do |line, line_index|
    line.split('|').map { |s| s.scan(/\d+/).map(&:to_i) }.then.sum do |first, second|
        (first[1...] & second).size.times do |dy|
            copies[line_index + dy + 1] += copies[line_index]
        end
        copies[line_index]
    end
end

pp res
