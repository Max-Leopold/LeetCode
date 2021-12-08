input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

def keys_for_value(hash, search_value)
    hash.select {|key, value| value == search_value}.keys
end

def untangle(signal_patterns)
    # We untangle the mapping for the signals by counting how often each segment on the display should light up
    # if we look at all possible digits the display can display.
    # Going through number 0 to 9 we see that the "a" segment lights up for 8 of the 10 digits.
    # Doing this for every segment gives us
    # a, c => 8
    # b => 6
    # d, g => 7
    # e => 4
    # f => 9
    # We see that we've got three counts that only one segment has to we can immediatly decode those by counting how
    # often each segment lights up in the broken signals patterns
    # For segments a, c and d, g we have the same count, so we have to decode them differently.
    # In the signal patterns we have four patters we assign to digits: 1, 4, 7, 8 as those use a unique number of segments
    # 1 => 2
    # 4 => 4
    # 7 => 3
    # 8 => 7
    # Now out of those identified patters we have to find a pattern that uses only one unindentified segment. 
    # To display 1 for example, the segments c and f are used. We already are able to decode f with the method described above
    # so we know that when using the pattern with a length of 2 (since 1 is the only digit using only 2 segments) the char in this
    # pattern that does not map to f has to map to c.
    # Since we now know the c mapping we know that the segment that lights up 8 times and does not map to c has to map to a.
    # To decode the mappings for d, g we do the same but instead of using the segments for the digit 1 we use the segments for the
    # digit 4 as we can identify the pattern for 4 by using the pattern length and it only includes on segment we haven't decoded
    # already (b, c, f are decoded; the only missing segment is f).
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