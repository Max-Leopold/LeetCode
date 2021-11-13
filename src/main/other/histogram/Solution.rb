values = [1, 40, 30, 20, 99, 32, 41, 45, 67, 77]

buckets = values.group_by {|v| v / 10}.sort.to_h
(0..9).each { |i|
    puts "#{i}: #{'*' * buckets[i].length if not buckets[i].nil?}"
}