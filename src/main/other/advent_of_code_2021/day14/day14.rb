initial_polymer = File.open(File.join(File.dirname(__FILE__), "initial_polymer.txt"), &:readline).chomp.split("")

polymer_table = File.open(File.join(File.dirname(__FILE__), "polymer_template.txt"), "r").map do |line|
    split_line = line.chomp.split(" -> ")
    [split_line[0].split(""), split_line[1]]
end.to_h

CACHE = {}

def next_polymer(polymer_pair, polymer_table, limit, step=0)
    return CACHE[(polymer_pair.to_s + step.to_s).hash] unless CACHE[(polymer_pair.to_s + step.to_s).hash].nil?
    inserted_element = polymer_table[polymer_pair]
    return [polymer_pair[0], inserted_element].tally if limit - 1 == step

    CACHE[(polymer_pair.to_s + step.to_s).hash] = \
    next_polymer([polymer_pair[0], inserted_element], polymer_table, limit, step + 1) \
        .merge(next_polymer([inserted_element, polymer_pair[1]], polymer_table, limit, step + 1)) {|key, v1, v2|
            v1 + v2
        }
end

polymer_counts = initial_polymer[0..-2].zip(initial_polymer[1..-1]).map {|polymer_pair|
    next_polymer(polymer_pair, polymer_table, 40)
}.inject {|agg, hash|
    agg.merge(hash) {|key, v1, v2|
        v1 + v2
    }
}
polymer_counts[initial_polymer[-1]] += 1
pp polymer_counts

pp polymer_counts.values.max - polymer_counts.values.min
