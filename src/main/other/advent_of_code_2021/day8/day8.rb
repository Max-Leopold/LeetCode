input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

def keys_for_value(hash, search_value)
    hash.select {|key, value| value == search_value}.keys
end

def untangle(signal_patterns)
    occurences = signal_patterns.join.split("").tally
    signal_mappings = {
        'b' => occurences.key(6),
        'e' => occurences.key(4),
        'f' => occurences.key(9)
    }
    one = signal_patterns.select {|pattern| pattern.length == 2}[0]
    signal_mappings['c'] = one.split("").select {|char| char != signal_mappings['f']}[0]
    signal_mappings['a'] = keys_for_value(occurences, 8).select {|key| key != signal_mappings['c']}[0]
    four = signal_patterns.select {|pattern| pattern.length == 4}[0]
    signal_mappings['d'] = four.split("").select {|char| char != signal_mappings['b'] && char != signal_mappings['c'] && char != signal_mappings['f']}[0]
    signal_mappings['g'] = keys_for_value(occurences, 7).select {|key| key != signal_mappings['d']}[0]
    signal_mappings.invert
end


def decode(signal_mappings, signals)
    signals.map {|signal|
        decoded_signals_string = signal.split("").map {|char|
            signal_mappings[char]
        }.sort.join
        case decoded_signals_string
        when "abcefg"
            0
        when "cf"
            1
        when "acdeg"
            2
        when "acdfg"
            3
        when "bcdf"
            4
        when "abdfg"
            5
        when "abdefg"
            6
        when "acf"
            7
        when "abcdefg"
            8
        when "abcdfg"
            9
        end
    }
end

tasks = input.map {|line| 
    signal_patterns, signals = line.split(" | ").map {|x| x.split(" ")}
}

decoded_signals = tasks.map {|signal_patterns, signals|
    signal_mappings = untangle(signal_patterns)
    decode(signal_mappings, signals)
}

puts "Day 8 Part 1: #{decoded_signals.flatten.select {|number| [1, 4, 7, 8].include? number }.count}"
puts "Day 8 Part 2: #{decoded_signals.map {|decoded_signal| decoded_signal.join.to_i}.flatten.sum}"