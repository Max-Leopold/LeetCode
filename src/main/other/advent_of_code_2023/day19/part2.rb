input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).chunk_while { [_1, _2].none?(&:empty?) }.to_a

OPERATIONS = input.first.map do |line|
    name, *operations, default = line.split(/[{},]/)
    operations = operations.map do |operation|
        cond, dest = operation.split(":")
        ->(intervals, accept) {
            case cond[1]
            when "<" then intervals[cond[0]][accept ? 1 : 0] = cond[2..].to_i + (accept ? -1 : 0)
            when ">" then intervals[cond[0]][accept ? 0 : 1] = cond[2..].to_i + (accept ? 1 : 0)
            end
            [intervals, dest]
        }
    end
    [name, operations + [->(intervals, accept) { [intervals, default] }]]
end.to_h

def find_intervals(intervals, state)
    return 0 if state == "R"
    return intervals.values.reduce(1) { |acc, interval| interval[0] > interval[1] ? 0 : (interval[1] - interval[0] + 1) * acc } if state == "A"
    res = OPERATIONS[state]&.map do |operation|
        [recursion(*(operation.(Marshal.load(Marshal.dump(intervals)), true))), operation.(intervals, false)]
    end.sum { _1[0] }
end

pp find_intervals({"x" => [1, 4000], "m" => [1, 4000], "a" => [1, 4000], "s" => [1, 4000]}, "in")