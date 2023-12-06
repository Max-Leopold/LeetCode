input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

# seeds = input[0].scan(/\d+/).map(&:to_i)
seeds = (79...93).to_a
pp seeds.size

def map_seeds(seeds, map)
    sorted_range = map.keys.sort_by! { _1[0] }

    seeds.map do |seed|
        s_range = sorted_range.bsearch { seed < _1[0] ? -1 : seed > _1[1] ? 1 : 0 }
        s_range ? map[s_range] + (seed - s_range[0]) : seed
    end
end

map = {}
input[1...].each do |line|
    d_start, s_start, l = line.scan(/\d+/).map(&:to_i)
    if d_start
        map[[s_start, s_start + l - 1]] = d_start
    else
        seeds = map_seeds(seeds, map)
        map = {}
    end
end

seeds = map_seeds(seeds, map)
pp seeds.sort!