input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

def map_range(range, map)
    sorted_ranges = map.keys.sort_by! { _1[0] }

    range_idx = sorted_ranges.bsearch_index { range[0] < _1[0] ? -1 : range[0] > _1[1] ? 1 : 0 }
    return [range] unless range_idx

    new_ranges = []
    current_range = range
    while true
        s_range = sorted_ranges[range_idx]
        unless s_range
            new_ranges << current_range
            break
        end

        if current_range[0] >= s_range[0] && current_range[1] <= s_range[1]
            new_ranges << [map[s_range] + (current_range[0] - s_range[0]), map[s_range] + (current_range[1] - s_range[0])]
            break
        elsif current_range[0] >= s_range[0] && current_range[1] > s_range[1]
            new_ranges << [map[s_range] + (current_range[0] - s_range[0]), map[s_range] + (s_range[1] - s_range[0])]
            current_range = [s_range[1] + 1, current_range[1]]
            range_idx += 1
        elsif current_range[0] < s_range[0] && current_range[1] >= s_range[0]
            new_ranges << [current_range[0], s_range[0] - 1]
            current_range = [s_range[0], current_range[1]]
        else
            new_ranges << current_range
            break
        end
    end

    new_ranges
end

ranges = input[0].scan(/\d+/).map(&:to_i).each_slice(2).map { |s, e| [s, s + e - 1] }

map = {}
input[1...].each do |line|
    d_start, s_start, l = line.scan(/\d+/).map(&:to_i)
    if d_start
        map[[s_start, s_start + l - 1]] = d_start
    else
        ranges = ranges.map do |range|
            map_range(range, map)
        end.flatten(1) unless map.empty?

        map = {}
    end
end

ranges = ranges.map do |range|
    map_range(range, map)
end.flatten(1)

pp ranges.min_by{_1}.first