input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map(&:chars)
CYCLES = 1000000000

def tilt(arr)
    arr.each do |line|
        l = 0
        line.each_with_index do |elem, r|
            line[l], line[r] = line[r], line[l] if elem == "O"
            l = r + 1 if elem == "#"
            l += 1 while line[l] != "." && l < r
        end
    end
    arr
end

map = {}
loop_entry = CYCLES.times.inject(input) do 
    break _1 if map[_1]
    map[_1] = map.size
    tilt(tilt(tilt(tilt(_1.transpose.reverse).reverse.transpose).reverse.transpose).reverse.transpose).reverse.map(&:reverse)
end
id = map[loop_entry] + ((CYCLES - map[loop_entry]) % (map.size - map[loop_entry]))
res = map.find { _2 == id }[0].map.with_index { |line, i| line.sum { _1 == "O" ? input.size - i : 0 } }.sum

pp res