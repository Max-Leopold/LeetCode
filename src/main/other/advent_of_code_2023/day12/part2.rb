input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map { _1.split(" ") }

def valid_arrangements(springs, groups, map)
    map[[springs, groups].hash] ||= begin
        return (springs&.include?("#") ? 0 : 1) if groups.empty?
        return 0 if !springs || springs.empty?

        res = ".?".include?(springs.first) ? valid_arrangements(springs[1..], groups, map) : 0
        res += if "#?".include?(springs.first) && springs.size >= groups.first && !springs[0...groups.first].include?(".") && springs[groups.first] != "#"
            valid_arrangements(springs[(groups.first + 1)..], groups[1..], map)
        end.to_i
    end
end

res = input.map do |springs, seq|
    valid_arrangements(((springs.chars + ["?"]) * 5)[...-1], seq.split(",").map(&:to_i) * 5, {})
end.sum

pp res