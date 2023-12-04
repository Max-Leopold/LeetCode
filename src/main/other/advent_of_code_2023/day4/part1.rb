input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

res = input.sum do |line|
    line.split('|').map { |s| s.scan(/\d+/).map(&:to_i) }.then.sum do |first, second|
        (2 ** ((first[1...] & second).size - 1)).floor
    end
end

pp res
