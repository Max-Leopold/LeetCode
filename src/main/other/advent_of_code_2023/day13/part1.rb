input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map { _1.tr(".#", "01").chars }.slice_before([])

def find_axis(arr)
    0.upto(arr.size - 2).each do |idx|
        steps = 0
        low, high = idx, idx + 1
        steps += 1 while idx - steps >= 0 && idx + steps + 1 < arr.size && arr[idx - steps] == arr[idx + steps + 1]
        return idx + 1 if idx - steps < 0 || idx + steps + 1 >= arr.size
    end
    nil
end

res = input.sum do 
    arr = _1.reject(&:empty?)
    find_axis(arr)&.*(100) || find_axis(arr.transpose)
end

pp res