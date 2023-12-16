input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map { _1.tr(".#", "01").chars }.slice_before([])

def find_axis(arr)
    0.upto(arr.size - 2).each do |idx|
        steps, diffs = 0, 0
        while idx - steps >= 0 && idx + steps + 1 < arr.size && diffs <= 1
            diffs += arr[idx - steps].zip(arr[idx + steps + 1]).count { _1 != _2 }
            steps += 1
        end
        return idx + 1 if (idx - steps < 0 || idx + steps + 1 >= arr.size) && diffs == 1
    end
    nil
end

res = input.sum do 
    arr = _1.reject(&:empty?)
    find_axis(arr)&.*(100) || find_axis(arr.transpose)
end

pp res